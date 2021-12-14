package com.bupt.service;

import com.bupt.exception.MaxSizeException;
import com.bupt.exception.SensitiveException;

/**
 * @Author czgggggggg
 * @Date 2021/12/13
 * @Description
 */
public interface UserService {
    void helloUser();
    boolean login(String username, String password) throws SensitiveException, MaxSizeException;
}
