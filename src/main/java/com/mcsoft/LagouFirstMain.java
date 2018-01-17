package com.mcsoft;

import com.mcsoft.service.LagouHandleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拉钩抓取main方法
 * Created by Mc on 2017/12/9.
 */
public class LagouFirstMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouHandleService handleService = context.getBean(LagouHandleService.class);
        handleService.firstStep();
    }
}
