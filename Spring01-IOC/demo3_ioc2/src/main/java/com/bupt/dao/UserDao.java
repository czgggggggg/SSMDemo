package com.bupt.dao;

import com.bupt.bean.User;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
public interface UserDao {
    User queryUserById(int id);
}
