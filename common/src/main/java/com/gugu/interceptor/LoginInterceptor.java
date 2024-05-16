package com.gugu.interceptor;

import com.gugu.common.UserHolder;
import com.gugu.exception.myException.NotLoginException;
import com.gugu.utils.JsonUtil;
import com.gugu.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

/**
 * @author Gugu
 * @create 2023-04-11 22:21
 * @purpose 远程调用服务方获取数据，登录拦截
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    StringRedisTemplate redis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = request.getHeader("x-auth-token");
        if(StringUtils.isNotBlank(userToken)){
            userToken = URLDecoder.decode(userToken,"UTF-8");
            String json = redis.opsForValue().get(userToken);
            UserDTO userInfo = JsonUtil.toObject(json,UserDTO.class);
            //将UserInfo放入上下文中
            UserHolder.saveUser(userInfo);
            redis.expire(userToken,30, TimeUnit.MINUTES);
        }else{
            throw new NotLoginException("您未登录");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
