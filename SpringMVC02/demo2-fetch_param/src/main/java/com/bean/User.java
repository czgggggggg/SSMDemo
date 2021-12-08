package com.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author czgggggggg
 * @Date 2021/12/8
 * @Description
 */
@Data
public class User {
    String username;
    String password;
    int age;
    boolean married;
    UserDetail userDetail;
    String[] hobbys;
    List<Course> courses;
}
