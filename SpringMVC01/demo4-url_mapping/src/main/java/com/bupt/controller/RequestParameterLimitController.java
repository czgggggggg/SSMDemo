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
@RequestMapping("parameter")
public class RequestParameterLimitController {
//    @RequestMapping(value = "login",params = "username")
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/view/login.jsp");
//        return modelAndView;
//    }

//    @RequestMapping(value = "login",params = {"username","password"})
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/view/login.jsp");
//        return modelAndView;
//    }

    @RequestMapping(value = "login",params = {"username!=root","password"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/login.jsp");
        return modelAndView;
    }
}
