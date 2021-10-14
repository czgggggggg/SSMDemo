package com.bupt.service;

import com.bupt.bean.User;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/10/14
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{

    public void sayHello(String name) {
        System.out.println("Hello," + name + "!");
    }

    public User queryUserById(int id) {
        if(id == 1){
            User user = new User();
            user.setUsername("czgbyer");
            user.setPassword("123456");
            return user;
        }
        return null;
    }

    //(*,*)
    public void hello(String str, int a){}
}
