package wxy.dao.impl;

import org.springframework.stereotype.Component;
import wxy.dao.IAccountDao;

@Component("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
