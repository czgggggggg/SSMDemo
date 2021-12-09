package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class SessionVauleController {
    @RequestMapping("put/session/{username}")
    public String putSessionValue(HttpSession session, @PathVariable("username") String username){
        session.setAttribute("username", "czgbyer");
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("get/session")
    public String getSessionValue(@SessionAttribute("username") String username){
        System.out.println("username = " + username);
        return "/WEB-INF/view/ok.jsp";
    }

//    @RequestMapping("get/session")
//    public String getSessionValue(HttpSession session){
//        Object username = session.getAttribute("username");
//        System.out.println("username = " + username);
//        return "/WEB-INF/view/ok.jsp";
//    }
}
