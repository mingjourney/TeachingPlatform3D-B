package com.healthy.essay.service;

import com.healthy.common.ResultResponse;

/**
 * @author Gugu
 * @create 2023-05-03 9:07
 * @purpose
 */
public interface EssayService {
    ResultResponse getEssayTypeByUser(Boolean flag);
    ResultResponse getEssayListByType(Integer type);
    ResultResponse getEssayById(Integer id, String token);
    ResultResponse addUserFavorite(Integer essayId);
    ResultResponse deleteUserFavorite(Integer essayId);
    ResultResponse getUserFavoritesByUserId();
    ResultResponse getUserBrowseHistoryByUserId();
    ResultResponse getEssayCommendByUser();
    ResultResponse addComment(Integer essayId, String comment);
    ResultResponse getEssayComments(Integer essayId);

}
