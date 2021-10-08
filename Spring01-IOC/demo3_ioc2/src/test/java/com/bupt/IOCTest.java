package com.bupt;

import com.bupt.bean.User;
import com.bupt.dao.UserDao;
import com.bupt.dao.UserDaoImpl;
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
    @Test//使用se的形式来写
    public void test1(){
        UserDaoImpl userDao = new UserDaoImpl();
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);

        User user = userService.queryUserById(19);
        System.out.println("uesr = " + user);
    }

    @Test//使用spring的形式来写
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) applicationContext.getBean(UserServiceImpl.class);
        User user = userService.queryUserById(23);
        System.out.println("user = " + user);
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        UserDao userDao = userService.getUserDao();

        UserDao userDaoFromIoc = applicationContext.getBean(UserDao.class);

        System.out.println(userDao == userDaoFromIoc);
    }
}
