package com.bupt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
//单独注册这个组件，这个组件对容器的其他bean都生效
//当前bean不会指定到BeanPostProcessor
public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("6.CustomBeanPostProcessor 的 Before");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("9.CustomBeanPostProcessor 的 After");
        return bean;
    }
}
