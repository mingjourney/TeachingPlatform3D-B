package com.gugu.service;

import com.gugu.common.ResultResponse;
import com.gugu.dto.ClassroomDTO;
import com.gugu.dto.SignInForm;

/**
 * @author Gugu
 * @create 2023-04-24 10:58
 * @purpose
 */
public interface ClassroomService {

//    ResultResponse login(String login,String password,Integer type);
//
//    ResultResponse signin(String email,String mobile,String password,String checkCode);
//    ResultResponse sendEmailValidation(String email);
//
//    ResultResponse getUserInfo();
    ResultResponse getClassroomList(Integer pageIndex, Integer pageSize);
    ResultResponse getRecommendedClassroom();
    ResultResponse addClassroom(ClassroomDTO classroom);
    ResultResponse getClassroomDetailById(Integer id);
    ResultResponse getUserCourseHistory();


//    ResultResponse updatePassword(String password);
//
//    ResultResponse saveUserInfo(SignInForm userInfo);
//
//    ResultResponse saveWeight(Double weight);
}
