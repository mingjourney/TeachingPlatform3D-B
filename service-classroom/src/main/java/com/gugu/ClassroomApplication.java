package com.gugu;

import com.gugu.annotation.EnableTransUserTransmitter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.gugu"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransUserTransmitter
public class ClassroomApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class,args);
    }
}
