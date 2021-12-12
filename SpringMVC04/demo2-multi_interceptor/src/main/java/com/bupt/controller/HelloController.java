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
    @RequestMapping("hello")
    public String hello1() throws Exception {
        System.out.println("hello");
        if(true){
            throw new Exception();
        }
        return "/WEB-INF/view/ok.jsp";
    }
}
