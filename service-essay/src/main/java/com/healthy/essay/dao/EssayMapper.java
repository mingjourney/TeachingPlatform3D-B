package com.healthy.essay.dao;

import com.gugu.dto.BrowsingHistoryDTO;
import com.gugu.dto.EssaySearchDTO;
import com.gugu.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-03 9:14
 * @purpose
 */
@Mapper
public interface EssayMapper {

    List<HealthCategory> getHealthCategoryType(List<Integer> ids);

    List<Essay> getEssayListByType(Integer type);
    List<Essay> getEssayListByInfo(EssaySearchDTO essaySearchDTO);
    int getEssayCountByInfo(EssaySearchDTO essaySearchDTO);
    Essay getEssayById(Integer id);

    void insertBrowsingHistory(BrowsingHistoryDTO browsingHistory);

    void updateEssayViewCount(Integer essayId);

    int insertUserFavorite(UserFavorite userFavorite);

    int deleteUserFavorite(Integer essayId, Integer userId);
    List<Essay> getEssayByIds(List<Integer> ids);
    List<UserFavorite> getUserFavoritesByUserId(Integer userId);

    int updateEssayFavoriteCount(Integer essayId, int count);
    void updateBrowseRecordTimestamp(Integer userId, Integer essayId, LocalDateTime viewedAt);

    List<BrowsingHistory> getUserBrowseHistoryByUserId(Integer userId);
    Integer getUserBrowseCount(Integer userId, Integer essayId);
    int addComment(Integer userId, Integer essayId, String comment);

    List<Comment> getEssayComments(Integer essayId);


}
