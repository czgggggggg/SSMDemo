package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author czgggggggg
 * @Date 2021/12/11
 * @Description
 */
@Controller
public class HelloController {
    @RequestMapping("hello1")
    public String hello1(){
        System.out.println("hello1");
        return "/WEB-INF/view/ok.jsp";
    }
    //preHandle
    //hello1
    //postHandle
    //afterCompletion

    //preHandle

    @RequestMapping("hello2")
    public String hello2(){
        System.out.println("hello2");
        return "/WEB-INF/view/ok.jsp";
    }
    //preHandle
    //hello2
    //postHandle
    //afterCompletion

    //preHandle
}
