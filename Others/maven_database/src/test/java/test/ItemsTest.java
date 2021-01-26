package test;

import Test.dao.ItemsDao;
import Test.dao.impl.ItemsDaoImpl;
import Test.domain.Item;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ItemsTest {


    @Test
    public void findAll() throws SQLException, ClassNotFoundException {

        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Item> list = itemsDao.findAll();

        for(Item items : list){
            System.out.println(items.getName());
        }
    }
}
