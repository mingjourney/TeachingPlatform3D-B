package com.healthy.heathy.controller;

import com.gugu.common.ResultResponse;
import com.gugu.dto.TargetForm;
import com.healthy.heathy.service.TargetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-05-01 14:22
 * @purpose
 */
@RestController
@RequestMapping("target")
@CrossOrigin
@Api("用户操作")
public class TargetController {

    @Resource
    TargetService targetService;

    @PostMapping("addTarget")
    @ApiOperation(value = "添加目标")
    public ResultResponse addTarget(@RequestBody TargetForm target){
        return targetService.addTarget(target);
    }
}
