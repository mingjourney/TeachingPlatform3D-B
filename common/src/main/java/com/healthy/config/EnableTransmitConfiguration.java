package com.healthy.config;

import com.healthy.interceptor.TransmitInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author Gugu
 * @create 2023-04-12 8:43
 * @purpose 设置拦截器
 */
public class EnableTransmitConfiguration {
    @Bean
    public TransmitInterceptor getTransmitInterceptor() {
        return new TransmitInterceptor();
    }
}
