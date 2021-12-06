package com.bupt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author czgggggggg
 * @Date 2021/11/6
 * @Description
 */
@Repository
public class AccountDapImpl implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int selectMoneyById(int id) {
        String sql = "select money from 20_account where id = ?";
        return jdbcTemplate.queryForObject(sql, int.class, id);
    }

    public int updateMoneyById(int id, int money) {
        String sql = "update 20_account set money = ? where id = ?";
        return jdbcTemplate.update(sql,money,id);
    }
}
