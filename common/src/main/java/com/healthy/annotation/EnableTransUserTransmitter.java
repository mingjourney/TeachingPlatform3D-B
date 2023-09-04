package com.healthy.annotation;

import com.healthy.config.EnableTransmitConfiguration;
import com.healthy.config.JacksonConfig;
import com.healthy.config.LoginInterceptorConfig;
import com.healthy.config.SwaggerConfiguration;
import com.healthy.exception.ExceptionAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Gugu
 * @create 2023-04-12 8:52
 * @purpose 注解启动基本架构
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({EnableTransmitConfiguration.class, LoginInterceptorConfig.class, JacksonConfig.class, SwaggerConfiguration.class, ExceptionAdvice.class})
public @interface EnableTransUserTransmitter {
}
