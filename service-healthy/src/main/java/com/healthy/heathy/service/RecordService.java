package com.healthy.heathy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.healthy.common.ResultResponse;
import com.healthy.dto.DateDataForm;

/**
 * @author Gugu
 * @create 2023-04-29 8:23
 * @purpose
 */
public interface RecordService {
    ResultResponse saveWeightDate(Double weight);

    ResultResponse addDateData(DateDataForm data);

    ResultResponse getSportTypes();

    ResultResponse getDatePlanToday() throws JsonProcessingException;
}
