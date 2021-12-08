package com.bupt.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author czgggggggg
 * @Date 2021/12/8
 * @Description
 */
@Controller
public class ReturnValueController {
    //返回值为void并不推荐使用
    @RequestMapping("return/void")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/void.jsp").forward(request,response);
    }

    @RequestMapping("return/string")
    public String returnString(Model model){
        model.addAttribute("key","czgbyer nb666 !!!");
//        return "/WEB-INF/view/string.jsp";
//        return "WEB-INF/view/string.jsp";
        return "string";
    }
}
