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
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
    //preHandle1
    //hello
    //postHandle1
    //afterCompletion1

    //preHandle1
    //preHandle2
    //hello
    //postHandle2
    //postHandle1
    //afterCompletion2
    //afterCompletion1

    @RequestMapping("hello/abc")
    public String helloabc(){
        System.out.println("hello/abc");
        return "hello/abc";
    }
    //preHandle1
    //hello/abc
    //postHandle1
    //afterCompletion1

    //preHandle1
    //preHandle2
    //hello/abc
    //postHandle2
    //postHandle1
    //afterCompletion2
    //afterCompletion1

    @RequestMapping("hello/abc/def")
    public String helloabcdef(){
        System.out.println("hello/abc/def");
        return "hello/abc/def";
    }
    //preHandle1
    //hello/abc/def
    //postHandle1
    //afterCompletion1

    //preHandle1
    //preHandle2
    //hello/abc/def
    //postHandle2
    //postHandle1
    //afterCompletion2
    //afterCompletion1

    @RequestMapping("hello2/abc/def")
    public String hello2abcdef(){
        System.out.println("hello2/abc/def");
        return "hello2/abc/def";
    }
    //hello2/abc/def

    //preHandle1
    //preHandle2
    //hello
    //postHandle2
    //postHandle1
    //afterCompletion2
    //afterCompletion1

    //preHandle2
    //preHandle3
    //hello2/abc/def
    //postHandle3
    //postHandle2
    //afterCompletion3
    //afterCompletion2

    @RequestMapping("hello2/abc")
    public String hello2abc(){
        System.out.println("hello2/abc");
        return "hello2/abc";
    }
    //hello2/abc

    //preHandle2
    //preHandle3
    //hello2/abc
    //postHandle3
    //postHandle2
    //afterCompletion3
    //afterCompletion2
}