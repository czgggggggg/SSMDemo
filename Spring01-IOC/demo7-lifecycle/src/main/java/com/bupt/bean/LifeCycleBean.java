package com.bupt.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean {
    String param;

    public LifeCycleBean() {
        System.out.println("1.init");
    }

    public void setParam(String param) {
        this.param = param;
        System.out.println("2.set方法");
    }

    public String getParam() {
        return param;
    }

    public void setBeanName(String s) {
        System.out.println("3.BeanNameAware的setBeanName：" + s);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4.BeanFactoryAware");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5.ApplicationContextAware");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("7.InitializingBean");
    }

    public void myinit(){
        System.out.println("8.custom init");
    }

    public void destroy() throws Exception {
        System.out.println("10.DisposableBean");
    }

    public void mydestroy(){
        System.out.println("11.custom destory");
    }
}
