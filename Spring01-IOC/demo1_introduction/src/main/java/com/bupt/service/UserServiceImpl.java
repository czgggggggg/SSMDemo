package com.bupt.service;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class UserServiceImpl implements UserService {
    public String sayHello(String name) {
        String content = "hello," + name;
        System.out.println("content = " + content);
        return content;
    }
}
