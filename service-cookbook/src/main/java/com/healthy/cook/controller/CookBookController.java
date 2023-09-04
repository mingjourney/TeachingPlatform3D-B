package com.healthy.cook.controller;

import com.healthy.common.ResultResponse;
import com.healthy.cook.service.CookBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Gugu
 * @create 2023-05-06 21:44
 * @purpose
 */
@RestController
@RequestMapping("cookbook")
@Api("菜谱")
public class CookBookController {

    @Resource
    CookBookService cookBookService;

    @GetMapping("cookType")
    @ApiOperation("获取菜品类型")
    public ResultResponse getCookType(){
        return cookBookService.getCookType();
    }

}
