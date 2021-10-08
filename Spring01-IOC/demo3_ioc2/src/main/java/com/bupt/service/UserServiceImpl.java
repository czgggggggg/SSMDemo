package com.bupt.service;

import com.bupt.bean.User;
import com.bupt.dao.UserDao;
import com.bupt.dao.UserDaoImpl;
import lombok.Data;

/**
 * @Author czgggggggg
 * @Date 2021/10/8
 * @Description
 */
@Data
public class UserServiceImpl implements UserService {

//    UserDao userDao = new UserDaoImpl();
    UserDao userDao;

    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    public UserDao getUserDao() {
//        return userDao;
//    }
}
