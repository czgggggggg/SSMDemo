package com.bupt.dao;

import com.bupt.bean.User;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public class UserDaoImpl implements UserDao {
    public User queryUserById(int id) {
        User user = new User();
        if(id > 24){
            user.setUsername("czgbyer");
        }else{
            user.setUsername("czgggggggg");
        }
        return user;
    }
}
