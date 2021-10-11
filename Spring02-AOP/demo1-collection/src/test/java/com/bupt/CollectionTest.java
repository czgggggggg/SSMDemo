package com.bupt;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class CollectionTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Object collectionBean1 = applicationContext.getBean("collectionBean");
        System.out.println("collectionBean1 = " + collectionBean1);
        //collectionBean1 = CollectionBean(arrayData=[string1, string2, string3], listData=[1, 2, 3], setData=[string1, string2, string3], mapData={key1=value1, key2=value2, key3=value3}, properties={key3=value3, key2=value2, key1=value1})

        Object collectionBean2 = applicationContext.getBean("collectionBean2");
        System.out.println("collectionBean = " + collectionBean2);
        //collectionBean = CollectionBean2(arrayData=[User(username=czgbyer1, password=1234561), User(username=czgbyer, password=123456)], listData=[User(username=czgbyer1, password=1234561), User(username=czgggggggg1, password=1234567891)], setData=[User(username=czgbyer, password=123456), User(username=czgggggggg, password=123456789)], mapData={key1=User(username=czgbyer, password=123456), key2=User(username=czgbyer1, password=1234561), key3=User(username=czgggggggg, password=123456789)})
    }
}
