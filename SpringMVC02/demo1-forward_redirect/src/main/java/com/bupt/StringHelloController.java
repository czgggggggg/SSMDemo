package com.bupt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author czgggggggg
 * @Date 2021/12/8
 * @Description  返回值为字符串做请求的转发和重定向
 */
@Controller
public class StringHelloController {

    @RequestMapping("request/forward")
    public String forward(){
        System.out.println("forward()方法");
        return "forward:/receive/forward";  // /receive/forward就不是viewName，而是url
        //最前面加上/,如果不加的话，做的也是相对路径
//        return "forward:receive/forward"; //转发的url就是request/receive/forward
    }

    @RequestMapping("receive/forward")
    public String receiveForward(){
        System.out.println("接收forward过来的请求");
        return "/WEB-INF/view/forward.jsp";
    }

    @RequestMapping("request/redirect")
    public String redirect(){
        System.out.println("redirect()方法");
        return "redirect:/receive/redirect";
    }

    @RequestMapping("receive/redirect")
    public String receiveRedirect(){
        System.out.println("接收redirect过来的请求");
        return "/WEB-INF/view/redirect.jsp";
    }
}
