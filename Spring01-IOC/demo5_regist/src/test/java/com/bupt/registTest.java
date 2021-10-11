package com.bupt;

import com.bupt.bean.AllAgrsContructorBean;
import com.bupt.bean.NoArgsConstructorBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/9
 * @Description
 */
public class registTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        NoArgsConstructorBean bean1 = (NoArgsConstructorBean) applicationContext.getBean("noArgs");
        System.out.println(bean1);

        AllAgrsContructorBean bean2 = (AllAgrsContructorBean) applicationContext.getBean("allArgs");
        System.out.println(bean2);
    }
}
