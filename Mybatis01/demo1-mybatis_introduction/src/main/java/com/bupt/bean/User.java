package com.bupt.bean;

import lombok.Data;

/**
 * @Author czgggggggg
 * @Date 2021/12/15
 * @Description  在入门案例1中 javabean的成员变量名和关系表中的列名一致
 */
@Data
public class User {
    int id;
    String Username;
    String password;
    int age;
    String gender;
}
