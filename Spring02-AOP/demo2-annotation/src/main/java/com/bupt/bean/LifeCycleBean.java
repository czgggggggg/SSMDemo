package com.bupt.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
@Component
public class LifeCycleBean {
    @PostConstruct
    public void init(){
        System.out.println("lifecycle init");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("lifecycle destroy");
    }
}
