package com.bupt.service.impl;

import com.bupt.bean.BaseRespVo;
import com.bupt.exception.MaxSizeException;
import com.bupt.exception.SensitiveException;
import com.bupt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    public void helloUser() {
        //制造一个除零异常
        int i = 1/0;
    }

    public BaseRespVo login(String username, String password) throws SensitiveException, MaxSizeException {
        if("czgbyer_hhh".equals(username) || "czgggggggg_hhh".equals(username)){
            throw new SensitiveException("你的用户名属于敏感词",username);
        }

        if(username != null && username.length() > 15){
            throw new MaxSizeException("你输入的用户名长度为：" + username.length());
        }

        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setStatus(0);
        baseRespVo.setErrmsg("OK");
        return baseRespVo;
    }
}
