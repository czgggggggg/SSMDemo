package com.bupt;

import com.bupt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author czgggggggg
 * @Date 2021/10/14
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AspectAnnotationTest {
    @Autowired
    UserService userService;

    @Test
    public void mytest1(){
        userService.sayHello1("czgbyer");
    }

    @Test
    public void mytest2(){
        userService.sayHello2("czgggggggg");
    }
}
