package Test.dao.impl;

import Test.dao.ItemsDao;
import Test.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 要想从数据库中取出数据
 * 必须有四个属性：数据库驱动，连接数据库的地址，数据库用户名称，数据库密码
 *
 */
public class ItemsDaoImpl implements ItemsDao {
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<Item>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection 对象
            connection = DriverManager.getConnection("jdbc:mysql:///runoob?serverTimezone=UTC","root","admin");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from runoob_test_tbl");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库结构集转为java的List集合
            while(rs.next()){
                Item items = new Item();
                items.setId(rs.getInt("runoob_count"));
                items.setName(rs.getString("runoob_author"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }



        return list;
    }
}
