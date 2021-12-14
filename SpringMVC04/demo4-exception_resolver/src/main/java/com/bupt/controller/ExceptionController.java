package com.bupt.controller;

import com.bupt.exception.MaxSizeException;
import com.bupt.exception.SensitiveException;
import com.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author czgggggggg
 * @Date 2021/12/13
 * @Description
 */
@Controller
public class ExceptionController {
    @Autowired
    UserService userService;

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello");
        userService.helloUser();
        return "/WEB-INF/view/hello.jsp";
    }

    @RequestMapping("login")
    public String login(String username, String password) throws SensitiveException, MaxSizeException {
        boolean login = userService.login(username, password);
        return "/WEB-INF/view/hello.jsp";
    }
}
