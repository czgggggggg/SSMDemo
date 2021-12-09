package com.bupt.controller;

import com.bupt.bean.User;
import com.bupt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("user/query/{idz}")
    public String queryUserById(@PathVariable("idz") int id){
        User user = userService.queryUserById(id);
        System.out.println("user = " + user);
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("{username}/article/detail/{articleId}")
    public String queryArticleDetail(@PathVariable("username") String username,
                                     @PathVariable("articleId") int articleId){
        System.out.println("username = " + username);
        System.out.println("articleId = " + articleId);
        return "/WEB-INF/view/ok.jsp";
    }
}
