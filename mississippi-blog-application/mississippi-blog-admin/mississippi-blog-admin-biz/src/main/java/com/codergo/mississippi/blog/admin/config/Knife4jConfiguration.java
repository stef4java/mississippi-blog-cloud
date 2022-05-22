package com.codergo.mississippi.blog.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Profile("!prod")
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("mississippi-blog RESTful APIs")
                        .description("# mississippi-blog RESTful APIs")
                        .termsOfServiceUrl("https://www.codergogogo.com/")
                        .contact(new Contact("程序员冲冲冲",
                                "https://codergogogo.com",
                                "setf4java@gmail.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("1.0.0版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.codergo.mississippi.blog.admin.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}