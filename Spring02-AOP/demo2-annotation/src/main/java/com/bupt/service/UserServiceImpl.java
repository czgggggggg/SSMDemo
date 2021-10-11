package com.bupt.service;

import com.bupt.dao.UserDao;
import com.bupt.dao.UserDaoImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
//@Data
//@Component//userServiceImpl
//@Component("userService")
@Service
//@Service("userService")
public class UserServiceImpl implements UserService {
//    UserDao userDao = new UserDaoImpl();
    @Autowired
//    @Qualifier
//    @Qualifier("userDaoImpl")
//    @Resource
//    @Resource(name = "userDaoImpl")
    UserDao userDao;

//    @Value("czgbyer666")
//    String userInfo;
//    @Value("10")
//    Integer maxSize;

    @Value("${user.userInfo}")
    String userInfo;
    @Value("${user.maxSize}")
    Integer maxSize;

    public void sayHi(String name) {
        name = name + userInfo + maxSize;
        userDao.sayHi(name);
    }
}
