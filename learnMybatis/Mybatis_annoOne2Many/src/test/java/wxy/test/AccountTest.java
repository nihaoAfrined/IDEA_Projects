package wxy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wxy.dao.IAccountDao;
import wxy.dao.IUserDao;
import wxy.domain.Account;
import wxy.domain.User;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testfindAll(){
        List<Account> accounts = accountDao.findAll();
        accounts = accountDao.findAll();
        for(Account account : accounts){
            System.out.println("----------------每个账户的信息-----------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }





}
