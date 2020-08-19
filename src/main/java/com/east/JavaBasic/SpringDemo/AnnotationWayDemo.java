package com.east.JavaBasic.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname AnnotationWayDemo
 * @Description 通过注解方式来注入
 * @Date 2020/8/19 4:14 下午
 * @Created by East
 */
@Component
public class AnnotationWayDemo {
    @Autowired // 使用Autowired 将User类注入进来
    User user;

    public AnnotationWayDemo(@Autowired MailService mailService) {

    }
}
