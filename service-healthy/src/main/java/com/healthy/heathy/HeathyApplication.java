package com.healthy.heathy;

import com.gugu.annotation.EnableTransUserTransmitter;
import com.lilittlecat.chatgpt.offical.ChatGPT;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author Gugu
 * @create 2023-04-23 21:58
 * @purpose
 */

@SpringBootApplication(scanBasePackages = {"com.healthy"})
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransUserTransmitter
public class  HeathyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeathyApplication.class,args);
    }

    @Bean
    public ChatGPT getChatGPT() {
        OkHttpClient client = new OkHttpClient.Builder().
                proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890))).connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build();
        return new ChatGPT("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",client);
    }
}
