package com.healthy.heathy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gugu.common.ResultResponse;
import com.healthy.heathy.service.ChatGPTService;
import com.healthy.heathy.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-05-03 14:40
 * @purpose
 */
@RestController
@RequestMapping("plan")
@CrossOrigin
@Api("计划")
public class DatePlanController {
    @Resource
    RecordService recordService;

    @Resource
    ChatGPTService chatGPTService;
    @GetMapping("getDatePlanToday")
    @ApiOperation(value = "获取当日计划")
    public ResultResponse getDatePlan(Integer level) throws JsonProcessingException {
        return chatGPTService.getDatePlan(level);
//        return recordService.getDatePlanToday();
    }
}
