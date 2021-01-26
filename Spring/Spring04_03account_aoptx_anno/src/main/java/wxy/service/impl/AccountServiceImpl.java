package wxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wxy.dao.IAccountDao;
import wxy.domain.Account;
import wxy.service.IAccountService;
import wxy.utils.TransactionManager;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao) {
//        this.accountDao = accountDao;
//    }


    @Override
    public List<Account> findAllAccount() {
            List<Account> accounts = accountDao.findAllAccount();
            return accounts;
    }

    @Override
    public Account findAccountById(int accountId) {
            Account account = accountDao.findAccountById(accountId);
            return account;
    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }


    @Override
    public void transfer(String sourceName, String targetName, Float money) {

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
    }

}
