package com.gugu.service.serviceImpl;

import cn.hutool.extra.mail.MailUtil;
import com.gugu.common.ResultResponse;
import com.gugu.common.ResultType;

import com.gugu.common.UserHolder;
import com.gugu.dao.UserMapper;
import com.gugu.dto.SignInForm;
import com.gugu.dto.UserDTO;
import com.gugu.dto.UserLoginForm;
import com.gugu.service.UserService;
import com.gugu.utils.JsonUtil;
import com.gugu.utils.ReturnUtil;
import com.gugu.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Gugu
 * @create 2023-04-24 10:58
 * @purpose
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Resource
    StringRedisTemplate redis;
    @Override
    public ResultResponse login(String login, String password, Integer type) {
        UserLoginForm user;
        System.out.println(login);
        System.out.println(password);
        System.out.println(type);
        if(type==2){
            user = userMapper.getUserLoginForm(login,null);
        }else{
            user = userMapper.getUserLoginForm(null,login);
        }
        if(user==null){
            return ResultResponse.info(ResultType.NOTHAVEAOCCUNT);
        }
        if(!user.getPassword().equals(password)){
            return ResultResponse.info(ResultType.PASSWARD);
        }
        String token = TokenUtil.token(login, password);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setMobile(user.getMobile());
        userDTO.setNickname(user.getNickname());
        userDTO.setRole(user.getRole());
        userDTO.setId(user.getId());
        assert token != null;
        redis.opsForValue().set(token, JsonUtil.toJson(userDTO));
        HashMap<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("nickanme",user.getNickname());
        map.put("role",user.getRole());
        return ResultResponse.success("登录成功",map);
    }

    @Override
    public ResultResponse signin(String email, String mobile, String password,String checkCode) {
        String test;
        int userLoginForm = userMapper.haveUser(email,mobile);
        if(userLoginForm>0){
            return ResultResponse.error("该账号已存在");
        }
        if(StringUtils.isNotBlank(email)){
            test = redis.opsForValue().get("CHECK_"+email);
        }else{
            test = redis.opsForValue().get("CHECK_"+mobile);
        }
        System.out.println(test+":"+checkCode);
        if(checkCode.equals(test)){
            int i = userMapper.signIn(email, mobile,password);
            if(i==0){
                return ResultResponse.info("注册失败");
            }else{
                String token = TokenUtil.token(email,checkCode);
                UserDTO userDTO = new UserDTO();
                userDTO.setEmail(email);
                userDTO.setMobile(mobile);
                userDTO.setNickname("");
                userDTO.setRole("user");
                userDTO.setId(i);
                assert token != null;
                redis.opsForValue().set(token, JsonUtil.toJson(userDTO));
                HashMap<String,Object> map = new HashMap<>();
                map.put("token",token);
                redis.delete("CHECK_"+email);
                redis.delete("CHECK_"+mobile);
                return ResultResponse.success("注册成功",map);
            }
        }
        return ResultResponse.error("验证码错误");
    }

    @Override
    public ResultResponse sendEmailValidation(String email) {
        ResultResponse result = new ResultResponse();
        if(!StringUtils.isEmpty(email)){
            System.out.println("send1"+email);
            double validation = Math.random()*9000+1000;
            MailUtil.send(email, "小蕃系统", "邮件来自小蕃系统的验证码："+ (int) validation, false);
            System.out.println("send2"+email);
            redis.opsForValue().set("CHECK_"+email,String.valueOf((int)validation));
            result.setCode("20000");
            result.setMessage("发送成功你好");
        }else{
            result.setCode(ResultType.WARNING.value());
            result.setMessage("邮箱未填写");
        }
        return result;
    }

    @Override
    public ResultResponse getUserInfo() {
        UserDTO user = UserHolder.getUser();
        SignInForm userInfo = userMapper.getUserInfo(user.getId());
        return ResultResponse.success("查询成功",userInfo);
    }

    @Override
    public ResultResponse updatePassword(String password) {
        UserDTO user = UserHolder.getUser();
        int i = userMapper.updatePassword(password, user.getId());
        return ReturnUtil.returnResult(i,"修改成功","修改失败");
    }

    @Override
    public ResultResponse saveUserInfo(SignInForm userInfo) {
        UserDTO user = UserHolder.getUser();
        int i = userMapper.saveUserInfo(userInfo, user.getId());
        return ReturnUtil.returnResult(i,"修改成功","修改失败");
    }

    @Override
    public ResultResponse saveWeight(Double weight) {
        UserDTO user = UserHolder.getUser();
        int i = userMapper.saveWeight(weight, user.getId());
        return ReturnUtil.returnResult(i,"更新成功","更新失败");
    }
}
