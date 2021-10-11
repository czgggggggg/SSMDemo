package com.bupt;

import com.bupt.dao.UserDao;
import com.bupt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class AnnotationFinalTest {
    @Autowired
    UserService userService;

    @Resource
    UserDao userDao;

    @Test
    public void test1(){
        userService.sayHi("czg");
    }
}
