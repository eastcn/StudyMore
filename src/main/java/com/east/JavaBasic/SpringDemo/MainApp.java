package com.east.JavaBasic.SpringDemo;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Classname MainApp
 * @Description Main
 * @Date 2020/8/20 11:55 上午
 * @Created by East
 */
public class MainApp {
    public static void main(String[] args) {
//        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));// 新建一个BeanFactory
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml"); // 与BeanFactory中的XmlBeanFactory效果一样

        HelloSpring hello = (HelloSpring) context.getBean("HelloSpring");
//        hello.setMessage("hello spring");
        System.out.println(hello.getMessage());
    }
}
