package com.mcsoft;

import com.mcsoft.service.LagouHandleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拉勾网数据处理入口
 * Created by Mc on 2017/12/21.
 */
public class LagouSecondMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouHandleService handleService = context.getBean(LagouHandleService.class);
        handleService.secondStep();
    }
}

