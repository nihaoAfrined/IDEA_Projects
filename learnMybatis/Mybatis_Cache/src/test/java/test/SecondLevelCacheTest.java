package test;

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

public class SecondLevelCacheTest {

    private  InputStream in;
    private SqlSessionFactory factory;
//    private SqlSession sqlSession;
//    private IUserDao userDao;

    @Before//用于在测试方法执行之执行
    public void init() throws  Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
        factory = new SqlSessionFactoryBuilder().build(in);
//        //3.使用工厂生产SqlSession
//        sqlSession = factory.openSession(true);
//        //4.使用SqlSession创建Dao接口的代理对象
//        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{

        //提交事务
//        sqlSession.commit();
//
//        sqlSession.close();
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testFirstLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        IUserDao dao1 = sqlSession1.getMapper(IUserDao.class);
        User user1 = dao1.findById(41);
        System.out.println(user1);

        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        IUserDao dao2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);

        sqlSession2.close();

        System.out.println(user1 == user2);
    }


//    @Test
//    public void testClearCache(){
//        User user1 = userDao.findById(41);
//        System.out.println(user1);
//
//        //2.更新用户信息
//        user1.setUsername("update user clear cache");
//        user1.setAddress("浙江省杭州市");
//        userDao.updateUser(user1);
//
//        sqlSession.clearCache(); //此方法也可以清空缓存
//
//        //再次获取Sqlsession对象
//        User user2 = userDao.findById(41);
//        System.out.println(user2);
//
//        System.out.println(user1 == user2);
//    }

}
