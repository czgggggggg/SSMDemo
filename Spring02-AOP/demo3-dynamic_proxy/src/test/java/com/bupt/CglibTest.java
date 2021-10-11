package com.bupt;

import com.bupt.service.UserService;
import com.bupt.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class CglibTest {
    @Test
    public void test1(){
        final UserServiceImpl userService = new UserServiceImpl();

        UserService userServiceProxy = (UserService) Enhancer.create(UserService.class,
                new InvocationHandler() {
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("before...");
                        Object invoke = method.invoke(userService, objects);
                        System.out.println("after...");
                        return invoke;
                    }
                });

        userServiceProxy.sayHello("czgbyer");
    }
}
