package com.bupt.exception;

import com.bupt.bean.BaseRespVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.NoSuchAlgorithmException;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description
 */
@RestControllerAdvice
//@ControllerAdvice
//@ResponseBody
public class CustomExceptionController {

    //ExceptionHandler注解中的value为exception的class数组→ 当发生对应的异常时，由该方法处理
    @ExceptionHandler(SensitiveException.class)
    //@ResponseBody
    public BaseRespVo resolveSensitiveException(SensitiveException e){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setStatus(500);
        baseRespVo.setErrmsg(e.getMessage());
        return baseRespVo;
    }

    @ExceptionHandler({MaxSizeException.class, NoSuchAlgorithmException.class})
    public BaseRespVo resolveMaxSizeException(MaxSizeException e){
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setStatus(500);
        baseRespVo.setErrmsg(e.getMessage());
        return baseRespVo;
    }
}
