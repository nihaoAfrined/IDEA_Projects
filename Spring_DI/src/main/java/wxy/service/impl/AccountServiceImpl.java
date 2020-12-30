package wxy.service.impl;

import wxy.dao.IAccountDao;
import wxy.dao.impl.AccountDaoImpl;
import wxy.service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void saveAccount(){



        System.out.println("service中的saveAccount方法执行了。。。");
        System.out.println("测试git");
    }
}
