package com.gugu.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gugu
 * @create 2023-04-24 10:24
 * @purpose Feign远程调用传递用户信息
 */
@Slf4j
public class TransmitInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        //从应用上下文中取出user信息，放入Feign的请求头中
//        UserDTO user = UserHolder.getUser();
//        if (user != null) {
//            try {
//                String userJson = JsonUtil.toJson(user);
//                template.header("USER_INFO", URLDecoder.decode(userJson,"UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                log.error("用户信息设置错误",e);
//            }
//        }
        //传递token
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            //将token信息放入header中
            template.header("x-auth-token",request.getHeader("x-auth-token"));
        }
    }
}
