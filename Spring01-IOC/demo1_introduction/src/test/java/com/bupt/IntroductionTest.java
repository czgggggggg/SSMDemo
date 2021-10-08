package com.bupt;

import com.bupt.service.UserService;
import com.bupt.service.UserServiceImpl;
import org.junit.Test;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class IntroductionTest {
    @Test
    public void mytest1(){
        //控制 就是获得实例的过程
        UserServiceImpl userService1 = new UserServiceImpl();
        userService1.sayHello("czgbyer");

        UserService userService2 = new UserServiceImpl();
        userService2.sayHello("czgggggggg");
    }
    @Test
    public void mytest2(){
        //控制 就是获得实例的过程 反转给了Spring
        //伪代码：
//        UserService userService = SpringContainer.getBean("userService");
//        UserService.sayHello("czgbyer");
    }
}
