package wxy.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wxy.service.IAccountService;

@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {

    @Autowired
    private TransactionManager txManager;

//    public void setTxManager(TransactionManager txManager) {
//        this.txManager = txManager;
//    }

    @Pointcut("execution(* wxy.service.impl.*.*(..))")
    private void pt1(){}

    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();

            txManager.beginTransaction();

            rtValue = pjp.proceed(args);

            txManager.commit();

            return rtValue;

        }catch (Throwable e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            txManager.release();
        }
    }
}
