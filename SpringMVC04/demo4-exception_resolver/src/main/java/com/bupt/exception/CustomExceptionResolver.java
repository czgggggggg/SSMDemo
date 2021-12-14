package com.bupt.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author czgggggggg
 * @Date 2021/12/13
 * @Description
 */
@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {

//    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/view/exception.jsp");
//        return modelAndView;
//    }

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/view/exception.jsp");

        //根据异常的不同，按照不同的方式处理ModelAndView
        //根据异常的类型的不同，可以做个性化的分发
        if(e instanceof SensitiveException){
            //类型转换成对应的异常类型
            SensitiveException sensitiveException = (SensitiveException)e;
            String word = sensitiveException.getWord();
            String message = sensitiveException.getMessage();
            modelAndView.setViewName("/WEB-INF/view/sensitive.jsp");
            modelAndView.addObject("name",word);
            modelAndView.addObject("message",message);
        }else if(e instanceof MaxSizeException){
            MaxSizeException maxSizeException = (MaxSizeException)e;
            String message = maxSizeException.getMessage();
            modelAndView.setViewName("/WEB-INF/view/maxSize.jsp");
            modelAndView.addObject("message",message);
        }else{
            modelAndView.setViewName("/WEB-INF/view/exception.jsp");
        }




        return modelAndView;
    }
}
