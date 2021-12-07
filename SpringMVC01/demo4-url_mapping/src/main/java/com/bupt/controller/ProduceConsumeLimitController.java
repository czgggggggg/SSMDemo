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
public class ProduceConsumeLimitController {

    @RequestMapping(value = "consume", consumes = "application/abc")
    public ModelAndView consume(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/consume.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "produce", produces = "application/json")
    public ModelAndView produce(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/view/produce.jsp");
        return modelAndView;
    }
}
