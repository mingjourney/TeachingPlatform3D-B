package com.gugu.controller;

import com.gugu.common.ResultResponse;
import com.gugu.common.UserHolder;
import com.gugu.dto.SignInForm;
import com.gugu.dto.UserDTO;
import com.gugu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gugu
 * @create 2023-04-23 22:00
 * @purpose
 */
@RestController
@RequestMapping("users")
@CrossOrigin
@Api("用户操作")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    @ApiOperation(value = "登录")
    public ResultResponse login(String login,String password,Integer type){
        return userService.login(login,password,type);
    }

    @PostMapping("signin")
    @ApiOperation(value = "邮箱手机注册")
    public ResultResponse signin(String email,String mobile,String password,String code){
        //type 1为手机 2为邮箱
        return userService.signin(email, mobile,password,code);
    }

    @PostMapping("sendCheck")
    @ApiOperation(value = "发送验证码")
    public ResultResponse emailTest(String email,String mobile){
        if(StringUtils.isNotBlank(email)){
            return userService.sendEmailValidation(email);
        }
        return ResultResponse.error("未填写");
    }

    @PostMapping("testLogin")
    @ApiOperation(value = "测试登录")
    public ResultResponse testLogin(){
        UserDTO user = UserHolder.getUser();
        return user==null?ResultResponse.error("未登录"):ResultResponse.success("已登录");
    }

    @GetMapping("info")
    @ApiOperation(value = "获取用户信息")
    public ResultResponse getUserInfo(){
        return userService.getUserInfo();
    }

    @PostMapping("savePassword")
    @ApiOperation(value = "更新用户密码")
    public ResultResponse updatePassword(String password){
        return userService.updatePassword(password);
    }

    @PostMapping("saveUserInfo")
    @ApiOperation("保存用户信息")
    public ResultResponse saveUserInfo(@RequestBody SignInForm userInfo){
        return userService.saveUserInfo(userInfo);
    }

    @PostMapping("saveWeight")
    @ApiOperation("保存用户体重")
    public ResultResponse saveWeight(@RequestParam("weight") Double weight){
        return userService.saveWeight(weight);
    }

    @PostMapping("mobile")
    public ResultResponse mobileTest(String mobile){
        return ResultResponse.success("ok");
    }
}
