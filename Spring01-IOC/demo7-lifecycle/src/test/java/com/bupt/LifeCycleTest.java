package com.bupt;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class LifeCycleTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        applicationContext.close();
    }
}
