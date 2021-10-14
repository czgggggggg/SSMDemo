package com.bupt;

import com.bupt.bean.User;
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
public class AdvisorTest {
    @Autowired
    UserService userService;

    @Test
    public void test1(){
        userService.sayHello("czgbyer");
    }

    @Test
    public void test2(){
        User user = userService.queryUserById(1);
        System.out.println("user = " + user);
    }
}
