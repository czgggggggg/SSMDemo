package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class OrderController {
    @RequestMapping("user/order")
    public String userOrder(@RequestParam("page") int page666,
                            @RequestParam("limit") int limit666){
        System.out.println("page666 = " + page666);
        System.out.println("limit666 = " + limit666);
        return "/WEB-INF/view/ok.jsp";
    }
}
