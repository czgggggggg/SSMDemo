package com.bupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class SessionController {
    @RequestMapping("put/session")
    public String putSessionValue(HttpSession session, String username){
        session.setAttribute("username",username);
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("get/session")
    public String getSessionValue(HttpSession session, Model model){
        Object username = session.getAttribute("username");
        model.addAttribute("username_zzz",username);
        return "/WEB-INF/view/ok.jsp";
    }
}
