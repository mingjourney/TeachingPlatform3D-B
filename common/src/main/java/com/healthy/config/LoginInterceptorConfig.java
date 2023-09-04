package com.healthy.config;

import com.healthy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Gugu
 * @create 2023-04-11 22:19
 * @purpose 全局登录拦截器
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
    /**
     * 被拦截的路径
     */
    String[] addPathPatterns = {
            "/**"
    };
    /**
     * 忽略路径
     */
    String[] excludePathPatterns = {
            "/users/login",
            "/users/signin",
            "/users/sendCheck",
            "/essay/getEssayTypeByUser",
            "/essay/getEssayTypeAll",
            "/essay/getEssayDetailById",
            "/essay/getEssayByType",
            "/essay/getComments",
            "/webjars/**",
            "swagger-ui.html",
            "/doc.html"
    };


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
