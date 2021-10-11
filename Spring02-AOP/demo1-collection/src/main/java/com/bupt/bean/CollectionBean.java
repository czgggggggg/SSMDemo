package com.bupt.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@Data
public class CollectionBean {
    String[] arrayData;
    List<Integer> listData;
    Set<String> setData;
    Map<String,String> mapData;
    Properties properties;
}