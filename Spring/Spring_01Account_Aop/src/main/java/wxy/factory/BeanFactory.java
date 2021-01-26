package wxy.factory;

import wxy.domain.Account;
import wxy.service.IAccountService;
import wxy.service.impl.AccountServiceImpl;
import wxy.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            method.invoke(accountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        }catch (Exception e){
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }

}
