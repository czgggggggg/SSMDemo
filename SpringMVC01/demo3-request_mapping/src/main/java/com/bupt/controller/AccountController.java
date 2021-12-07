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
public class AccountController {
    @RequestMapping("account/hello1")
    public ModelAndView hello1(){
        System.out.println("AccountController.hello1()");
        return new ModelAndView();
    }
}
