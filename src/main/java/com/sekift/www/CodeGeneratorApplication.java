package com.sekift.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/03 11:21
 * @description:
 */
@SpringBootApplication
@MapperScan("com.sekift.www.dao")
public class CodeGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApplication.class, args);
    }
}
