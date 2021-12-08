package com.bupt;

import com.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author czgggggggg
 * @Date 2021/12/8
 * @Description
 */
@Controller
public class ParamController {
    @RequestMapping("param/request")
    public String paramRequest(HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        return "/WEB-INF/view/ok.jsp";
    }

//    @RequestMapping("param/direct")
//    public String paramDirect(String username, String password){
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("param/direct")
//    public String paramDirect(String username, String password, int age, boolean gender){
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("age = " + age);
//        System.out.println("gender = " + gender);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("param/direct")
//    public String paramDirect(String username, String password, Integer age, Boolean gender){
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("age = " + age);
//        System.out.println("gender = " + gender);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("param/javabean")
//    public String paramDirect(User user){
//        System.out.println("user = " + user);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("param/javabean/nested")
//    public String paramDirect(User user){
//        System.out.println("user = " + user);
//        return "/WEB-INF/view/ok.jsp";
//    }

//    @RequestMapping("param/javabean/nested/array")
//    public String paramDirect(User user){
//        System.out.println("user = " + user);
//        return "/WEB-INF/view/ok.jsp";
//    }

    @RequestMapping("param/javabean/nested/list")
    public String paramDirect(User user){
        System.out.println("user = " + user);
        return "/WEB-INF/view/ok.jsp";
    }
}
