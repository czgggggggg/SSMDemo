package com.bupt;

import com.bupt.bean.User;
import com.bupt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class ApplicationContextTest {
    /**
     * ClassPathXmlApplicationContext
     * classpath：resources（或java）下的文件名
     */
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.queryUserById(25);
        System.out.println("user = " + user);
    }

    /**
     * FileSystemXmlApplicationContext
     * 文件系统：文件的全名
     */
    @Test
    public void test2(){
        String configPath = "D:\\IDEAProjects\\SSMDemo\\Spring01-IOC\\demo3_ioc2\\src\\main\\resources\\application.xml";
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(configPath);
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = userService.queryUserById(25);
        System.out.println("user = " + user);
    }

    @Test//对比
    public void test3(){
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application.xml");
        UserService bean1 = (UserService) applicationContext1.getBean("userService");

        String configPath = "D:\\IDEAProjects\\SSMDemo\\Spring01-IOC\\demo3_ioc2\\src\\main\\resources\\application.xml";
        ApplicationContext applicationContext2 = new FileSystemXmlApplicationContext(configPath);
        UserService bean2 = (UserService) applicationContext2.getBean("userService");

        System.out.println(bean1 == bean2);//false

        System.out.println(applicationContext1);
        System.out.println(applicationContext2);
    }
}
