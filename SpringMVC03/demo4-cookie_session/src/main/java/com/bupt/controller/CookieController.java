package com.bupt.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class CookieController {
    @RequestMapping("get/cookie")
    public String getCookieValue(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println(name + " : " + value);
        }
        model.addAttribute("username_zzz","czgggggggg");
        return "/WEB-INF/view/ok.jsp";
    }
}
