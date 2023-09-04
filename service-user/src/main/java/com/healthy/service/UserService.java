package com.healthy.service;

import com.healthy.common.ResultResponse;
import com.healthy.dto.SignInForm;

/**
 * @author Gugu
 * @create 2023-04-24 10:58
 * @purpose
 */
public interface UserService {

    ResultResponse login(String login,String password,Integer type);

    ResultResponse signin(String email,String mobile,String password,String checkCode);
    ResultResponse sendEmailValidation(String email);

    ResultResponse getUserInfo();

    ResultResponse updatePassword(String password);

    ResultResponse saveUserInfo(SignInForm userInfo);

    ResultResponse saveWeight(Double weight);
}
