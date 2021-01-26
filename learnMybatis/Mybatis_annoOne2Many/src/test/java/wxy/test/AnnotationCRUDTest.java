package wxy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wxy.dao.IUserDao;
import wxy.domain.User;

import java.io.InputStream;
import java.security.PublicKey;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = new LinkedList<User>();
        users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println("---------------每个用户的信息---------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(57);
        System.out.println(user);

        User user2 = userDao.findById(57);
        System.out.println(user2);

        System.out.println(user == user2);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
//        List<User> users = userDao.findUserByName("mybatis");
        for(User user : users){
            System.out.println(user);
        }
    }


}
