package com.bupt.service;

import com.bupt.bean.User;

/**
 * @Author czgggggggg
 * @Date 2021/10/14
 * @Description
 */
public interface UserService {
    void sayHello(String name);
    User queryUserById(int id);
}
