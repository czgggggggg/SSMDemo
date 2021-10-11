package com.bupt;

import com.bupt.service.UserService;
import com.bupt.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AnotherTest {
    @Autowired
    UserService userService;
    @Test
    public void test1(){
//        UserService userService = new UserServiceImpl();
        userService.sayHi("annotation");
    }
}
