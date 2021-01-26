package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wxy.dao.IUserDao;
import wxy.dao.impl.UserDaoImpl;
import wxy.domain.User;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    private  InputStream in;
    //private SqlSession sqlSession;
    private IUserDao userDao;

    @Before//用于在测试方法执行之执行
    public void init() throws  Exception{
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception{

        //提交事务
        in.close();
    }

    /**
     * 入门案例
     * @param
     */
    @Test
    public void testFindAll() throws Exception {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws  Exception{
        User user = new User();
        user.setUsername("dao impl user");
        user.setAddress("浙江省杭州市");
        user.setSex("女");
        user.setBirthday(new Date());

        System.out.println("保存之前" + user);
        //5.执行保存方法
        userDao.saveUser(user);

        System.out.println("保存之后" + user);


        }

    /**
     * 测试更新
      * @throws Exception
     */
    @Test
    public void testUpdate() throws  Exception{
        User user = new User();
        user.setId(50);
        user.setUsername("mabatis Update user");
        user.setAddress("浙江省余杭区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行更新方法
        userDao.updateUser(user);

    }

    /**
     * 测试删除
     * @throws Exception
     */
    @Test
    public void testDelete() throws  Exception{


        //5.执行删除方法
        userDao.deleteUser(50);

    }

    @Test
    public void testFindByName(){
        //5.使用代理对象执行方法
        List<User> users = userDao.findByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }



    @Test
        public void testFindTotal(){
        //5.使用代理对象执行方法
        int count = userDao.findTotal();
        System.out.println(count);
    }


}

