package com.gugu;

import com.gugu.annotation.EnableTransUserTransmitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Gugu
 * @create 2023-04-23 21:58
 * @purpose
 */

@SpringBootApplication(scanBasePackages = {"com.gugu"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransUserTransmitter
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
