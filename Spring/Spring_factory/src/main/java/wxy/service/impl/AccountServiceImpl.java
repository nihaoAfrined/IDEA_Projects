package wxy.service.impl;

import wxy.dao.IAccountDao;
import wxy.dao.impl.AccountDaoImpl;
import wxy.factory.BeanFactory;
import wxy.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount(){
        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
