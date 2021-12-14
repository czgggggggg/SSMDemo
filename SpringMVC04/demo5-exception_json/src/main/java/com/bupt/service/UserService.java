package com.bupt.service;

import com.bupt.bean.BaseRespVo;
import com.bupt.exception.MaxSizeException;
import com.bupt.exception.SensitiveException;

/**
 * @Author czgggggggg
 * @Date 2021/12/14
 * @Description
 */
public interface UserService {
    void helloUser();
    BaseRespVo login(String username, String password) throws SensitiveException, MaxSizeException;
}
