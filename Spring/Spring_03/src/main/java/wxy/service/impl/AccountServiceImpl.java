package wxy.service.impl;

import wxy.dao.IAccountDao;
import wxy.dao.impl.AccountDaoImpl;
import wxy.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount(){

        accountDao.saveAccount();

    }
}
