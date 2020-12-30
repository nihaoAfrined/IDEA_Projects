package wxy.factory;

import wxy.service.IAccountService;
import wxy.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}