package com.healthy.essay.service;

import com.gugu.common.ResultResponse;
import com.gugu.dto.EssaySearchDTO;

/**
 * @author Gugu
 * @create 2023-05-03 9:07
 * @purpose
 */
public interface EssayService {
    ResultResponse getEssayTypeByUser(Boolean flag);
    ResultResponse getEssayListByType(Integer type);
    ResultResponse getEssayListByInfo(EssaySearchDTO essaySearchDTO);
    ResultResponse getEssayById(Integer id, String token);
    ResultResponse addUserFavorite(Integer essayId);
    ResultResponse deleteUserFavorite(Integer essayId);
    ResultResponse getUserFavoritesByUserId();
    ResultResponse getUserBrowseHistoryByUserId();
    ResultResponse getEssayCommendByUser();
    ResultResponse addComment(Integer essayId, String comment);
    ResultResponse getEssayComments(Integer essayId);

}
