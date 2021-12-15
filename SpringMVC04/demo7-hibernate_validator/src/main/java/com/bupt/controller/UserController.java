package com.bupt.controller;

import com.bupt.bean.BaseRespVo;
import com.bupt.bean.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author czgggggggg
 * @Date 2021/12/15
 * @Description
 */
@RestController
public class UserController {
    @RequestMapping("login")
    public Object login(@Valid User user, BindingResult bindingResult){
        System.out.println("user = " + user);
        BaseRespVo<User> userBaseRespVo = new BaseRespVo<User>();
        if(bindingResult.hasFieldErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            System.out.println(defaultMessage);

            userBaseRespVo.setStatus(400);
            userBaseRespVo.setErrmsg(defaultMessage);
            userBaseRespVo.setData(user);
            return userBaseRespVo;
        }
        userBaseRespVo.setStatus(0);
        userBaseRespVo.setErrmsg("成功");
        userBaseRespVo.setData(user);
        return userBaseRespVo;
    }
}
