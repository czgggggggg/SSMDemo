package com.bupt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Author czgggggggg
 * @Date 2021/11/4
 * @Description
 */
@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void hhh(JdbcTemplate jdbcTemplate){

    }

    public String selectNameById(int id) {
        String sql = "select name from 20_account where id = ?";
        String name = jdbcTemplate.queryForObject(sql, String.class, id);
        return name;
    }
}
