package com.bupt.service;

import com.bupt.anno.CountTime;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/10/16
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{
    @CountTime
    public void sayHello(String name) {
        System.out.println("Hello," + name + "!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sayHi(String name) {
        System.out.println("Hi," + name + "!");
    }
}
