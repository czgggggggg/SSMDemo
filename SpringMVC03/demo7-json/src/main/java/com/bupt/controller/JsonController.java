package com.bupt.controller;

import com.bupt.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * @Author czgggggggg
 * @Date 2021/12/10
 * @Description
 */
@Controller
public class JsonController {

    @RequestMapping("package/json1")
    public String packageJson(User user){
        System.out.println("user = " + user);
        //http://localhost:8080/package/json1?username=czgbyer&password=123456
        //user = User(username=czgbyer, password=123456)
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("package/json2")
    public String packageJson2(@RequestParam Map user){
        //http://localhost:8080/package/json2?username=czgbyer&password=123456
        //user = {username=czgbyer, password=123456}
        System.out.println("user = " + user);
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("package/json3")
    public String packageJson3(@RequestBody User user){
        System.out.println("user = " + user);
        //http://localhost:8080/package/json3?username=czgbyer&password=123456
        //user = User(username=czgbyer, password=123456)
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("package/json4")
    public String packageJson4(@RequestBody Map user){
        //http://localhost:8080/package/json4?username=czgbyer&password=123456
        //user = {username=czgbyer, password=123456}
        System.out.println("user = " + user);
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("package/json5")
    @ResponseBody
    public String packageJson5(@RequestBody User user){
        System.out.println("user = " + user);
        return "/WEB-INF/view/ok.jsp";
    }

    @RequestMapping("package/json6")
    @ResponseBody
    public User packageJson6(@RequestBody Map user){
        System.out.println("user = " + user);
        Object username = user.get("username");
        Object password = user.get("password");
        User user1 = new User();
        user1.setUsername("czgggggggg");
        user1.setPassword("654321");
        return user1;
    }
}
