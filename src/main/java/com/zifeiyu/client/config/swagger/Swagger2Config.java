package com.zifeiyu.client.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.zifeiyu.client.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("子非鱼接口文档")
                // 描述
                .description("子非鱼首页配置文档")
                //服务条款网址
                .termsOfServiceUrl("https://blog.csdn.net/ysk_xh_521")
                .version("1.0")
                // 创建人
                .contact(new Contact("Zi.Fei.Yu", "http://ysk521.cn", "532791689@qq.com"))
                .build();
    }

}
