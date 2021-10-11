package com.bupt.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@Repository
public class UserDaoImpl implements UserDao {
    public void sayHi(String name) {
        System.out.println("Hi," + name + "!");
    }
}
