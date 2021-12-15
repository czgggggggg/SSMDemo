package com.bupt.controller;

import com.bupt.bean.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    @Qualifier("messageSource")
    MessageSource messageSource;

    @RequestMapping("fetch/message/{key}")
    public BaseRespVo fetchMessage(@PathVariable("key") String key, String param1, String param2, Locale locale){
        /*
         * 第一个参数：message配置文件中的key
         * 第二个参数：可以给message配置文件中的值额外的填入一些值
         * 第三个参数：Locale
         * 根据语言的不同和key的不同，可以取出不同的消息
         * */

//        String message = messageSource.getMessage(key, null, Locale.getDefault());
//        String message = messageSource.getMessage(key, null, Locale.US);

        Object[] params = {param1, param2};
//        String message = messageSource.getMessage(key, params, locale);
//        String message = messageSource.getMessage(key, params, Locale.US);
        String message = messageSource.getMessage(key, params, Locale.CHINA);

        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setStatus(200);
        baseRespVo.setErrmsg(message);

        return baseRespVo;
    }
}
