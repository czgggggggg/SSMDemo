package com.bupt.service;

import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/10/14
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{
    public void sayHello1(String name) {
        System.out.println("Hello1," + name + "!");
    }

    public String sayHello2(String name) {
        String str = "Hello2," + name + "!";
        System.out.println(str);
        int i = 1/0;
        return str;
    }
}
