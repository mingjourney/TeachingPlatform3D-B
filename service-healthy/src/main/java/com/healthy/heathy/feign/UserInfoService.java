package com.healthy.heathy.feign;

import com.gugu.common.ResultResponse;
import com.gugu.dto.SignInForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gugu
 * @create 2023-04-29 8:43
 * @purpose
 */
@FeignClient("service-user")
public interface UserInfoService {
    @PostMapping("users/saveWeight")
    public ResultResponse updateWeight(@RequestParam("weight") Double weight);

    @GetMapping("userFeign/userInfo")
    public SignInForm getUserInfo();
}
