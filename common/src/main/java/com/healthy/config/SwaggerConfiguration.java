package com.healthy.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Gugu
 * @create 2023-03-19 10:58
 * @purpose Knife4j文档配置
 */
@Configuration
@EnableKnife4j
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket baseRestApi(){
        // 配置 Docket，它是 Knife4j 的核心配置类，用于生成 Swagger 的 API 文档
        return new Docket(DocumentationType.SWAGGER_2)// 指定使用 Swagger2 规范生成文
                .apiInfo(apiInfo()).select()// 设置 API 信息
                .apis(RequestHandlerSelectors.basePackage("com.heathy.controller"))// 设置 API 包路径
                .paths(PathSelectors.any())
                .build();
    }
    @Bean
    public ApiInfo apiInfo(){
        // 配置 API 信息，包括项目名称、版本号、API 文档描述等
        return new ApiInfoBuilder().title("健康文档").description("mall文档Swagger版").termsOfServiceUrl("")
                .contact(new Contact("蕃蕃科技公司","","")).build();
    }

}
