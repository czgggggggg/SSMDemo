package com.bupt.bean;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @Author czgggggggg
 * @Date 2021/12/15
 * @Description
 */
@Data
public class User {
//    @Size(min = 6, message = "min size limit 6")
    @Size(min = 6, message = "{user.username}")
    String username;

//    @Size(max = 10, message = "max size limit 10")
    @Size(max = 10, message = "{user.password}")
    String password;

    @Min(value = 0)
    @Max(value = 200)
    int age;
}
