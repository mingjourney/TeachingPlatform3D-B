package com.gugu.service.serviceImpl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.gugu.common.ResultResponse;
import com.gugu.common.UserHolder;
import com.gugu.dao.ClassroomMapper;
import com.gugu.dto.ClassroomDTO;
import com.gugu.dto.UserDTO;
import com.gugu.entity.*;
import com.gugu.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gugu
 * @create 2023-04-24 10:58
 * @purpose
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomMapper classroomMapper;

    @Resource
    StringRedisTemplate redis;

    @Override
    public ResultResponse getClassroomList(Integer pageIndex, Integer pageSize) {
        int offset = (pageIndex - 1) * pageSize;
        ArrayList<Classroom> classrooms = classroomMapper.getClassroomList(offset, pageSize);
        int total = classroomMapper.classroomTotal();
        Map<String, Object> result = new HashMap<>();
        result.put("classroomList", classrooms);
        result.put("total", total);
        return ResultResponse.success("查询成功", result);
    }
    @Override
    public ResultResponse addClassroom(ClassroomDTO classroom) {
        int capacity = classroom.getRows() * classroom.getColumns();
        classroom.setCapacity(capacity);
        classroom.setVacancyCount(capacity);
        int id = classroomMapper.addClassroom(classroom);
        return ResultResponse.success("添加成功", id);
    }
    @Override
    public ResultResponse getClassroomDetailById(Integer id) {
        Classroom classroom = classroomMapper.getClassroomDetailById(id);
        return ResultResponse.success("查询成功", classroom);
    }
    @Override
    public ResultResponse getUserCourseHistory() {
        UserDTO user = UserHolder.getUser();
        List<CourseHistory> history = classroomMapper.getUserCourseHistory(user.getId());

        // 处理结果并返回响应
        if (history != null && !history.isEmpty()) {
            return ResultResponse.success("获取用户浏览记录成功", history);
        } else {
            return ResultResponse.success("用户浏览记录为空", new ArrayList<>());
        }
    }
    @Override
    public ResultResponse getRecommendedClassroom() {
        UserDTO user = UserHolder.getUser();
        Integer userId = user.getId();
//        List<CommendEassyFromPy> recommendedArticles = callPythonService(userId);
//
//        // 提取推荐文章的id列表
//        List<Integer> essayIds = new ArrayList<>();
//        for (CommendEassyFromPy article : recommendedArticles) {
//            essayIds.add(article.getEssayId());
//        }
//        System.out.println("userId: " + userId + ", essayIds: " + essayIds);
//        // 调用essayMapper.getEssayByIds方法获取文章列表
//        List<Essay> essays = essayMapper.getEssayByIds(essayIds);
//
        return ResultResponse.success("查询成功", 1);
    }
    private List<CommendEassyFromPy> callPythonService(Integer userId) {
        List<CommendEassyFromPy> recommendedArticles = new ArrayList<>();

        try {
            URL url = new URL("http://localhost:11080/recommend");

            // 创建HttpURLConnection对象并设置请求方法为POST
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            connection.setRequestProperty("Content-Type", "application/json");
            String requestBody = "{\"userId\": " + userId + "}";

            connection.getOutputStream().write(requestBody.getBytes());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                String jsonStr = response.toString();
                JSONArray jsonArray = JSONUtil.parseArray(jsonStr);
                for (int i = 0; i < jsonArray.size(); i++) {
                    // 获取数组中的每个元素（是一个JSON数组）
                    JSONArray articleArray = jsonArray.getJSONArray(i);
                    int essayId = articleArray.getInt(0);
                    double weight = articleArray.getDouble(1);

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
