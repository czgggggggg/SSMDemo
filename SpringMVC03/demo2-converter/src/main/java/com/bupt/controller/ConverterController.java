package com.bupt.controller;

import com.bupt.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class ConverterController {
    @Autowired
    ConfigurableConversionService configurableConversionService;

    @RequestMapping("converter")
    public String converter(){
        System.out.println("configurableConversionService = " + configurableConversionService);
        return "/WEB-INF/view/ok.jsp";
    }

//    @RequestMapping("submit/date")
//    public String submitDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
//        System.out.println("date = " + date);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("submit/date2")
//    public String submitDate(User user){
//        System.out.println("user = " + user);
//        return "/WEB-INF/view/ok.jsp";
//    }

    @RequestMapping("submit/date")
    public String submitDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println("date = " + date);
        return "/WEB-INF/view/ok.jsp";
    }
}
