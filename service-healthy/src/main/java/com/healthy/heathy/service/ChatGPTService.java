package com.healthy.heathy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gugu.common.ResultResponse;

/**
 * @author Gugu
 * @create 2023-05-06 20:18
 * @purpose
 */
public interface ChatGPTService {
    public ResultResponse getDatePlan(Integer level) throws JsonProcessingException;

}
