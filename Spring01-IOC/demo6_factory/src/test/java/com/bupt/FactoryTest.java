package com.bupt;

import com.bupt.bean.Animal;
import com.bupt.factory.InstanceFactory;
import com.bupt.factory.StaticFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class FactoryTest {
    //se的形式
    @Test
    public void test1(){
        Animal animal1 = StaticFactory.createAnimal();//不需要实例化静态工厂，就可以创建一个Animal对象。

        InstanceFactory instanceFactory = new InstanceFactory();
        Animal animal2 = instanceFactory.createAnimal();
    }

    //spring的形式
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Object animalFromStaticFactory = applicationContext.getBean("animalFromStaticFactory");
        System.out.println(animalFromStaticFactory);

        Object animalFromInstanceFactory = applicationContext.getBean("animalFromInstanceFactory");
        System.out.println(animalFromInstanceFactory);
    }

}
