package wxy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wxy.config.SpringConfiguration;
import wxy.service.IAccountService;

public class AOPTest {

    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.transfer("aaa","bbb",100f);
    }
}
