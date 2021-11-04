package com.bupt;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author czgggggggg
 * @Date 2021/11/4
 * @Description
 */
public class SeTest {
    @Test
    public void test1(){
        //提供一个datasource
        DruidDataSource dataSource = new DruidDataSource();//控制 反转

        //数据源4大金刚：driverClassName、url、username、password
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql//localhost:3306/20_db");
        dataSource.setUrl("jdbc:mysql://localhost:3306/20_db?characterEncoding=utf-8&&serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //需要使用到JdbcTemplate的实例
        JdbcTemplate jdbcTemplate = new JdbcTemplate();//控制 反转
        jdbcTemplate.setDataSource(dataSource);

        String sql = "select name from 20_account where id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, 3);
        System.out.println("name = " + name);
    }
}
