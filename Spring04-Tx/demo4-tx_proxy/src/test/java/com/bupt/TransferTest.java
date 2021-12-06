package com.bupt;

import com.bupt.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author czgggggggg
 * @Date 2021/11/6
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TransferTest {
    @Autowired
    @Qualifier("accountServiceProxy")//如果是一个proxyFactoryBean要指定id
    AccountService accountService;

    @Test
    public void test(){
        accountService.transfer(1,2,2000);
    }
}
