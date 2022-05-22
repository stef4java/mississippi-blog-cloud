package com.codergo.mississippi.blog.admin.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator(){
        return Validation
                .byProvider(HibernateValidator.class)
                .configure()
                //快速失败，有一个失败立即返回
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }
}
