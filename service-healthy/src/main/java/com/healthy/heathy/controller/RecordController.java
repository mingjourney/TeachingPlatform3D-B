package com.healthy.heathy.controller;

import com.healthy.common.ResultResponse;
import com.healthy.dto.DateDataForm;
import com.healthy.heathy.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-04-29 8:17
 * @purpose
 */
@RestController
@RequestMapping("record")
@CrossOrigin
@Api("数据记录")
public class RecordController {

    @Resource
    RecordService recordService;

    @PostMapping("recordWeight")
    @ApiOperation(value = "记录体重")
    public ResultResponse recordWeight(Double weight){
        return recordService.saveWeightDate(weight);
    }

    @PostMapping("recordDailyData")
    @ApiOperation(value = "记录每日情况")
    public ResultResponse recordData(@RequestBody DateDataForm data){
        return recordService.addDateData(data);
    }

    @GetMapping("getSportList")
    @ApiOperation(value = "获取运动项目")
    public ResultResponse getSport(){
        return  recordService.getSportTypes();
    }

}
