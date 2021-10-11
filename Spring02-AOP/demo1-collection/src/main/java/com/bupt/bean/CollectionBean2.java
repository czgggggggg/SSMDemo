package com.bupt.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@Data
public class CollectionBean2 {
    User[] arrayData;
    List<User> listData;
    Set<User> setData;
    Map<String,User> mapData;
}
