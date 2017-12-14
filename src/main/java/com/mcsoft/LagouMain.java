package com.mcsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拉钩抓取main方法
 * Created by Mc on 2017/12/9.
 */
public class LagouMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

    }
}
