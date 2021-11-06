package com.bupt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/11/6
 * @Description
 */
@Service
public class AccountService {
    @Autowired
    UserService userService;
    public void methodB(){
        System.out.println("Hello methodB");
        userService.methodA();
    }
}
