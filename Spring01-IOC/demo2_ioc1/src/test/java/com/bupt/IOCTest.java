package com.bupt;

import com.bupt.service.UserService;
import com.bupt.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class IOCTest {

    @Test//反射
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName("com.bupt.service.UserServiceImpl");
        UserService o = (UserService) aClass.newInstance();
        o.sayHello("czgbyer");
    }

    @Test//方式1
    public void test2(){
        //spring容器提供了应用上下文applicationContext，通过应用上下文可以获得组件。
        //需要加载spring配置文件 -> 直接写resources（classpath）下的配置文件名。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        //getBean()中的字符串参数是，要获取的对象所属的组件的id
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello("czgbyer");
    }

    @Test//方式2
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        //class指的是类型  这个类型在容器中只有这一个组件
//        UserService userService = applicationContext.getBean(UserService.class);
        UserService userService = applicationContext.getBean(UserServiceImpl.class);
        userService.sayHello("czgbyer");
    }
}