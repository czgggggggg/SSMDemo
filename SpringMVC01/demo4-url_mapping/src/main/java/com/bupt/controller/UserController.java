package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author czgggggggg
 * @Date 2021/12/7
 * @Description
 */
@Controller
@RequestMapping("user")
public class UserController {
//    @RequestMapping("user/register")
    @RequestMapping("register")
    public ModelAndView register(){
        System.out.println("register()");
        return new ModelAndView();
    }

//    @RequestMapping("user/login")
    @RequestMapping("login")
    public ModelAndView login(){
        System.out.println("login()");
        return new ModelAndView();
    }

//    @RequestMapping("user/delete")
    @RequestMapping("delete")
    public ModelAndView delete(){
        System.out.println("delete()");
        return new ModelAndView();
    }
}
