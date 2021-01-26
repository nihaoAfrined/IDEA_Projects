package wxy.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import wxy.dao.IAccountDao;
import wxy.domain.Account;
import wxy.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
            Account account = accountDao.findAccountById(accountId);
            return account;
    }



    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                System.out.println("transfer...");
                //2.1根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.2根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //2.3转出账户减钱
                source.setMoney(source.getMoney() - money);
                //2.4转入账户加钱
                target.setMoney(target.getMoney() + money);
                //2.5更新转出账户
                accountDao.updateAccount(source);
                //2.6更新转入账户
                accountDao.updateAccount(target);

                return null;
            }
        });


    }

}
