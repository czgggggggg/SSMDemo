package com.bupt.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author czgggggggg
 * @Date 2021/12/9
 * @Description
 */
@Data
public class User {
//    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthday;
}
