package com.bupt;

import com.bupt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class AnnotationTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.sayHi("czgbyer");
    }
}
