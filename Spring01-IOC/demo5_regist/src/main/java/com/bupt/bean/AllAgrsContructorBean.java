package com.bupt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author czgggggggg
 * @Date 2021/10/9
 * @Description
 */
@Data
//@AllArgsConstructor
public class AllAgrsContructorBean {
    String username;
    String password;

    public AllAgrsContructorBean(String usernameA, String passwordA) {
        this.username = usernameA;
        this.password = passwordA;
    }

    public AllAgrsContructorBean() {
    }
}
