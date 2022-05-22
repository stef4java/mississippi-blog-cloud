package com.codergo.mississippi.blog.admin;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JasyptTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void jasyptTest() {
        String url = encryptor.encrypt("jdbc:mysql://localhost:3306/mississippi_blog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        String username = encryptor.encrypt("root");
        String password = encryptor.encrypt("root123456");
        log.info("url:{}", url);
        log.info("username:{}", username);
        log.info("password:{}", password);
    }
}