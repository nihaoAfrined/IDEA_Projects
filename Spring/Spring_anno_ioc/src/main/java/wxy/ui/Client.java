package wxy.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import wxy.dao.IAccountDao;
import wxy.service.IAccountService;
import wxy.service.impl.AccountServiceImpl;

import java.applet.AppletContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {


    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");   //容器创建好，对象也已经创建好了

        //2.根据id获取Bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService"); //强转类型
//        IAccountService as2 = (IAccountService)ac.getBean("accountService");

//        System.out.println(as);
//
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
        as.saveAccount();
        ac.close();
//        System.out.println(as == as2);


    }
}
