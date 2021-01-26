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

    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下
     *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（须有访问权限）
     *      AnnotationConfigApplicationContext:它是用于读取注解创建容器的
     *
     *核心容器的两个接口引发出的问题：
     *  ApplicationContext:      单例对象适用
     *      他在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建文件中配置的对象。
     *  BeanFactory:             多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是收，什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");   //容器创建好，对象也已经创建好了
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\lenovo\\Desktop\\bean.xml");
        //2.根据id获取Bean对象
//        IAccountService as = (IAccountService)ac.getBean("accountService"); //强转类型
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class); //赋予字节码

//        System.out.println(as);
//        System.out.println(adao);
 //       as.saveAccount();

        //BeanFactory
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)factory.getBean("accountService");
        IAccountService as = factory.getBean("accountService",IAccountService.class);
        System.out.println(as);
    }
}
