package com.bupt.service.impl;

import com.bupt.bean.User;
import com.bupt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    public User queryUserById(int id) {
        User user = new User();
        if(id > 10)
            user.setUsername("czgber");
        else
            user.setUsername("czgggggggg");
        return user;
    }
}
