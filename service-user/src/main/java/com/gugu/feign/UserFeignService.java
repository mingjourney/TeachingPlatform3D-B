package com.gugu.feign;

import com.gugu.dto.SignInForm;
import com.gugu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gugu
 * @create 2023-05-06 20:10
 * @purpose
 */
@RestController
@RequestMapping("userFeign")
public class UserFeignService {
    @Autowired
    UserService userService;

    @GetMapping("userInfo")
    public SignInForm getUserInfo(){
        return (SignInForm)userService.getUserInfo().getData();
    }
}
