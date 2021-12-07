package com.bupt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author czgggggggg
 * @Date 2021/12/7
 * @Description  这个controller中就可以包含多个handler
 */
@Controller
public class HelloController{
    @Autowired
    ApplicationContext applicationContext;

    //通过@RequestMapping注解，注解中的value则为请求url；将url和方法建立了映射关系
    //hello()这个方法其实就是一个handler
    @RequestMapping("hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/hello.jsp");
        modelAndView.addObject("key","czgbyer666");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }

        return modelAndView;
    }

    @RequestMapping("hello2")
    public ModelAndView hello2(){
        System.out.println("hello2()");
        return new ModelAndView();
    }
}