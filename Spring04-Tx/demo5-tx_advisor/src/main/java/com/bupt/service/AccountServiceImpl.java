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
    //没有采用事务的代码
    @Autowired
    AccountDao accountDao;

    public void transfer(int fromId, int toId, int money) {
        int fromMoney = accountDao.selectMoneyById(fromId) - money;//转账者少了钱
        int toMoney = accountDao.selectMoneyById(toId) + money;    //收账者多了钱

        accountDao.updateMoneyById(fromId,fromMoney);
        int i = 1 / 0;
        accountDao.updateMoneyById(toId,toMoney);
    }


//    //采用了事务的代码
//    @Autowired
//    AccountDao accountDao;
//    @Autowired
//    TransactionTemplate transactionTemplate;
//
//    public void transfer(final int fromId, final int toId, int money) {
//        final int fromMoney = accountDao.selectMoneyById(fromId) - money;//转账者少了钱
//        final int toMoney = accountDao.selectMoneyById(toId) + money;    //收账者多了钱
//
//        //侵入式的编程 → 改变了原有的编码
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                accountDao.updateMoneyById(fromId,fromMoney);
//                int i = 1 / 0;
//                accountDao.updateMoneyById(toId,toMoney);
//            }
//        });
//    }
}
