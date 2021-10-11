package com.bupt;

import com.bupt.service.UserService;
import com.bupt.service.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class JdkTest {
    @Test
    public void test1(){
        final UserService userService = new UserServiceImpl();//target对象
//        userService.sayHello("czgbyer");

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before...");
                        Object invoke = method.invoke(userService, args);
                        System.out.println("after...");
                        return invoke;
                    }
                });

        userServiceProxy.sayHello("czgbyer");
    }
}
