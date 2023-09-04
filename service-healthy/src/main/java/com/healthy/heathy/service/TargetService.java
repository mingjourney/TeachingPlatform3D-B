package com.healthy.heathy.service;

import com.healthy.common.ResultResponse;
import com.healthy.dto.TargetForm;

/**
 * @author Gugu
 * @create 2023-05-01 14:26
 * @purpose
 */
public interface TargetService {
    public ResultResponse addTarget(TargetForm targetForm);
}
