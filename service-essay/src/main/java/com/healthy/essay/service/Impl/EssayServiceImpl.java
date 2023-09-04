package com.healthy.essay.service.Impl;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.healthy.common.ResultResponse;
import com.healthy.common.UserHolder;
import com.healthy.dto.BrowsingHistoryDTO;
import com.healthy.dto.UserDTO;
import com.healthy.entity.*;
import com.healthy.essay.dao.EssayMapper;
import com.healthy.essay.service.EssayService;
import com.healthy.utils.JsonUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gugu
 * @create 2023-05-03 9:08
 * @purpose
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Resource
    EssayMapper essayMapper;
    @Resource
    StringRedisTemplate redis;
    @Override
    public ResultResponse getEssayTypeByUser(Boolean flag) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(flag){
            list.add(1);
            list.add(16);
            list.add(18);
//            for (int i = 0; i < 3; i++) {
//                list.add(i+1);
//            }
        }

        List<HealthCategory> healthCategoryType = essayMapper.getHealthCategoryType(list);
        return ResultResponse.success("查询成功",healthCategoryType);
    }
    @Override
    public ResultResponse getEssayCommendByUser(){
        UserDTO user = UserHolder.getUser();
        Integer userId = user.getId();
        List<CommendEassyFromPy> recommendedArticles = callPythonService(userId);

        // 提取推荐文章的id列表
        List<Integer> essayIds = new ArrayList<>();
        for (CommendEassyFromPy article : recommendedArticles) {
            essayIds.add(article.getEssayId());
        }
        System.out.println("userId: " + userId + ", essayIds: " + essayIds);
        // 调用essayMapper.getEssayByIds方法获取文章列表
        List<Essay> essays = essayMapper.getEssayByIds(essayIds);

        return ResultResponse.success("查询成功", essays);
    }

    @Override
    public ResultResponse getEssayListByType(Integer type) {
        List<Essay> essayListByType = essayMapper.getEssayListByType(type);
        return ResultResponse.success("查询成功",essayListByType);
    }


    @Override
    public ResultResponse getEssayById(Integer id, String token) {
        String userJson = redis.opsForValue().get(token);
        UserDTO userInfo = JsonUtil.toObject(userJson, UserDTO.class);
        Integer userId = userInfo.getId();
        saveBrowseRecord(userId, id);

        Essay essay = essayMapper.getEssayById(id);
        boolean isFavorite = isEssayFavorite(userId, id);

        EssayWithFavoriteStatus essayWithFavoriteStatus = new EssayWithFavoriteStatus();
        essayWithFavoriteStatus.setEssay(essay);
        essayWithFavoriteStatus.setFavorite(isFavorite);

        return ResultResponse.success("查询成功", essayWithFavoriteStatus);
    }

    private boolean isEssayFavorite(Integer userId, Integer essayId) {
        List<UserFavorite> favorites = essayMapper.getUserFavoritesByUserId(userId);
        return favorites.stream().anyMatch(favorite -> favorite.getEssayId().equals(essayId));
    }

    @Override
    public ResultResponse addUserFavorite(Integer essayId) {
        //通过用户id和文章Id添加收藏
        UserDTO user = UserHolder.getUser();
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(user.getId());
        userFavorite.setEssayId(essayId);
        userFavorite.setTimeAt();
        int rowsAffected = essayMapper.insertUserFavorite(userFavorite);
        if (rowsAffected > 0) {
            essayMapper.updateEssayFavoriteCount(essayId, 1);
            return ResultResponse.success("添加收藏成功");
        } else {
            return ResultResponse.error("添加收藏失败");
        }
    }

    @Override
    public ResultResponse addComment(Integer essayId, String comment) {
        // 通过用户ID和文章ID添加评论
        UserDTO user = UserHolder.getUser();

        try {
            essayMapper.addComment(user.getId(), essayId, comment);
//            essayMapper.updateEssayCommentCount(essayId, 1);
            return ResultResponse.success("添加评论成功");
        } catch (Exception e) {
            return ResultResponse.error("添加评论失败");
        }
    }
    @Override
    public ResultResponse getEssayComments(Integer essayId) {
        try {
            List<Comment> essayComments = essayMapper.getEssayComments(essayId);
//            essayMapper.updateEssayCommentCount(essayId, 1);
            return ResultResponse.success("获取评论成功",essayComments);
        } catch (Exception e) {
            return ResultResponse.error("获取评论失败");
        }
    }

    @Override
    public ResultResponse deleteUserFavorite(Integer essayId) {
        //通过用户id和文章id删除
        UserDTO user = UserHolder.getUser();
        int rowsAffected = essayMapper.deleteUserFavorite(essayId, user.getId());
        if (rowsAffected > 0) {
            essayMapper.updateEssayFavoriteCount(essayId, -1);
            return ResultResponse.success("删除收藏成功");
        } else {
            return ResultResponse.error("删除收藏失败");
        }
    }
    @Override
    public ResultResponse getUserFavoritesByUserId() {
        //通过用户id获取所有收藏
        UserDTO user = UserHolder.getUser();
        List<UserFavorite> favorites = essayMapper.getUserFavoritesByUserId(user.getId());
        if (favorites != null) {
            return ResultResponse.success("获取用户收藏成功", favorites);
        } else {
            return ResultResponse.error("获取用户收藏失败");
        }
    }

    @Override
    public ResultResponse getUserBrowseHistoryByUserId() {
        // 调用数据访问层方法获取用户浏览记录
        UserDTO user = UserHolder.getUser();

        List<BrowsingHistory> history = essayMapper.getUserBrowseHistoryByUserId(user.getId());

        // 处理结果并返回响应
        if (history != null && !history.isEmpty()) {
            return ResultResponse.success("获取用户浏览记录成功", history);
        } else {
            return ResultResponse.success("用户浏览记录为空", new ArrayList<>());
        }
    }

    private void saveBrowseRecord(Integer userId, Integer essayId) {
        Integer browseCount = essayMapper.getUserBrowseCount(userId, essayId);
        if (browseCount > 0) {
            // 更新时间戳
            essayMapper.updateBrowseRecordTimestamp(userId, essayId, LocalDateTime.now());
        } else {
            // 新增浏览记录
            BrowsingHistoryDTO browsingHistory = new BrowsingHistoryDTO();
            browsingHistory.setUserId(userId);
            browsingHistory.setEssayId(essayId);
            browsingHistory.setViewedAt(LocalDateTime.now());
            essayMapper.insertBrowsingHistory(browsingHistory);
        }
        essayMapper.updateEssayViewCount(essayId);
    }
    private List<CommendEassyFromPy> callPythonService(Integer userId) {
        List<CommendEassyFromPy> recommendedArticles = new ArrayList<>();

        try {
            // 构建URL对象，指定Python服务的URL地址
            URL url = new URL("http://localhost:11080/recommend");

            // 创建HttpURLConnection对象并设置请求方法为POST
            // 创建HttpURLConnection对象并设置请求方法为POST
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Type", "application/json");

            String requestBody = "{\"userId\": " + userId + "}";

            connection.getOutputStream().write(requestBody.getBytes());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // 解析响应数据为推荐文章列表
                // 这里假设响应数据为JSON数组，每个元素包含essayId和weight字段
                String jsonStr = response.toString();
                // 解析响应数据为JSON数组
                JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
                for (int i = 0; i < jsonArray.size(); i++) {
                    // 获取数组中的每个元素（是一个JSON数组）
                    JSONArray articleArray = jsonArray.getJSONArray(i);
                    int essayId = articleArray.getInt(0);
                    double weight = articleArray.getDouble(1);

                    // 创建 CommendEassyFromPy 对象并将其添加到推荐文章列表中
                    CommendEassyFromPy article = new CommendEassyFromPy();
                    article.setEssayId(essayId);
                    article.setWeight(weight);
                    recommendedArticles.add(article);
                }

            }
            connection.disconnect();
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }

        return recommendedArticles;
    }


}
