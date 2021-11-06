package com.bupt.service;

import com.bupt.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author czgggggggg
 * @Date 2021/11/6
 * @Description
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    public void transfer(int fromId, int toId, int money) {
        int fromMoney = accountDao.selectMoneyById(fromId) - money;//转账者少了钱
        int toMoney = accountDao.selectMoneyById(toId) + money;    //收账者多了钱

        accountDao.updateMoneyById(fromId,fromMoney);
        int i = 1 / 0;
        accountDao.updateMoneyById(toId,toMoney);
    }
}
