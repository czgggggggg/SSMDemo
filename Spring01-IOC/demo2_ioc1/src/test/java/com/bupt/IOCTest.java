package com.bupt;

import com.bupt.service.UserService;
import org.junit.Test;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class IOCTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> aClass = Class.forName("com.bupt.service.UserServiceImpl");
        UserService o = (UserService) aClass.newInstance();
        o.sayHello("czgbyer");
    }


}
