package com.bupt.dao;

/**
 * @Author czgggggggg
 * @Date 2021/11/6
 * @Description
 */
public interface AccountDao {
    int selectMoneyById(int id);

    int updateMoneyById(int id, int money);
}
