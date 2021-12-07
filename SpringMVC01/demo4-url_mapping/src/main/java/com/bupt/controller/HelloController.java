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
public class HelloController {
    @RequestMapping(value = {"hello11","hello12","hello13"})
    public ModelAndView hello1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello1.jsp");
        return modelAndView;
    }

    @RequestMapping("hello2*")
    public ModelAndView hello2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello2.jsp");
        return modelAndView;
    }

    @RequestMapping("hello3/*/abc")
    public ModelAndView hello3(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello3.jsp");
        return modelAndView;
    }
}
