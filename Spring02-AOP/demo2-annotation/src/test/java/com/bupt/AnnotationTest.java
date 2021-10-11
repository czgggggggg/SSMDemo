package com.bupt;

import com.bupt.bean.ScopeBean;
import com.bupt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:application.xml")
public class AnnotationTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.sayHi("czgbyer");
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        ScopeBean scopeBean1 = (ScopeBean) applicationContext.getBean("scopeBean");
        ScopeBean scopeBean2 = (ScopeBean) applicationContext.getBean("scopeBean");
        ScopeBean scopeBean3 = (ScopeBean) applicationContext.getBean("scopeBean");
        System.out.println(scopeBean1);
        System.out.println(scopeBean2);
        System.out.println(scopeBean3);
    }
    //@Scope
    //com.bupt.bean.ScopeBean@75329a49
    //com.bupt.bean.ScopeBean@75329a49
    //com.bupt.bean.ScopeBean@75329a49
    //@Scope("singleton)
    //com.bupt.bean.ScopeBean@75329a49
    //com.bupt.bean.ScopeBean@75329a49
    //com.bupt.bean.ScopeBean@75329a49
    //@Scope("prototype")
    //com.bupt.bean.ScopeBean@75329a49
    //com.bupt.bean.ScopeBean@161479c6
    //com.bupt.bean.ScopeBean@4313f5bc

    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        applicationContext.close();
    }

//    @Autowired
//    UserService userService;
//    @Test
//    public void test4(){
//        userService.sayHi("czg");
//    }
}
