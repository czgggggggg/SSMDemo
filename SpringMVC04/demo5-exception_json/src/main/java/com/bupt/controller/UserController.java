package com.bupt.controller;

import com.bupt.bean.BaseRespVo;
import com.bupt.exception.MaxSizeException;
import com.bupt.exception.SensitiveException;
import com.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public Object login(String username, String password) throws SensitiveException, MaxSizeException {
        BaseRespVo baseRespVo = userService.login(username, password);
        return baseRespVo;
    }
}
