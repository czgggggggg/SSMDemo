package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class HeaderValueController {
//    @RequestMapping("header/value")
//    public String getHeaderValue(@RequestHeader("Accept-Encoding") String acceptEncoding,
//                                 @RequestHeader("Accept") String accept){
//        System.out.println("acceptEncoding = " + acceptEncoding);
//        System.out.println("accept = " + accept);
//        return "/WEB-INF/view/ok.jsp";
//    }

    @RequestMapping("header/value")
    public String getHeaderValue(@RequestHeader("Accept-Encoding") String[] acceptEncoding,
                                 @RequestHeader("Accept") String[] accept){
        System.out.println("acceptEncoding = " + Arrays.asList(acceptEncoding));
        System.out.println("accept = " + Arrays.asList(accept));
        return "/WEB-INF/view/ok.jsp";
    }
}
