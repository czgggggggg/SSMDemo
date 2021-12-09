package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class CharacterController {
    @RequestMapping("login")
    public String login(String username,String password){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "/WEB-INF/view/ok.jsp";
    }
}
