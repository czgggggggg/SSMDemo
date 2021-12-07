package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author czgggggggg
 * @Date 2021/12/7
 * @Description
 */
@Controller
@RequestMapping("method")
public class RequestMethodLimitController {
//    @RequestMapping(value = "get",method = RequestMethod.GET)
    @GetMapping("get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/get.jsp");
        return modelAndView;
    }

//    @RequestMapping(value = "post",method = RequestMethod.POST)
    @PostMapping("post")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/post.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "multi",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView multi(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/multi.jsp");
        return modelAndView;
    }
}
