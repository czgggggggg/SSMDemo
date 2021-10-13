package com.bupt.service;

import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/10/13
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{
    public void sayHello(String name) {
        System.out.println("Hello," + name + "!");
    }
}
