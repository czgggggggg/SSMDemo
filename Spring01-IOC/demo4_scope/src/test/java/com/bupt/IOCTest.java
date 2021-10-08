package com.bupt;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class IOCTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService bean1 = (UserService) applicationContext.getBean("userService");
        UserService bean2 = (UserService) applicationContext.getBean("userService");
        System.out.println(bean1 == bean2);
        //默认情况下：true
        //scope=singleton  true
        //scope=prototype  false
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application.xml");
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("application.xml");
        UserService bean1 = (UserService) applicationContext1.getBean("userService");
        UserService bean2 = (UserService) applicationContext2.getBean("userService");
        System.out.println(bean1 == bean2);//false
    }
}
