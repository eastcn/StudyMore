package com.east.JavaBasic.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Config
 * @Description TODO
 * @Date 2020/8/19 4:21 下午
 * @Created by East
 */
@Configuration
@ComponentScan
public class Config {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        
    }
}
