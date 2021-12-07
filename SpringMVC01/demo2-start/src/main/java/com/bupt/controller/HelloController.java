package com.bupt.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author czgggggggg
 * @Date 2021/12/7
 * @Description
 */
//@Component("/hello")
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //view
        //viewName写的是相对于web根路径下的视图,写的时候注意最前面有个/
        modelAndView.setViewName("/WEB-INF/view/hello.jsp");
        //model
        modelAndView.addObject("key","czgbyer6666");
        return modelAndView;
    }
}
