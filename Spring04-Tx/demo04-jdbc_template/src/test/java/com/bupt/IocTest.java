package com.bupt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author czgggggggg
 * @Date 2021/11/4
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class IocTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        String sql = "select name from 20_account where id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, 3);
        System.out.println("name = " + name);
    }
}
