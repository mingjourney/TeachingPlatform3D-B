package com.healthy.heathy.service;

import com.gugu.common.ResultResponse;
import com.gugu.dto.TargetForm;

/**
 * @author Gugu
 * @create 2023-05-01 14:26
 * @purpose
 */
public interface TargetService {
    public ResultResponse addTarget(TargetForm targetForm);
}
