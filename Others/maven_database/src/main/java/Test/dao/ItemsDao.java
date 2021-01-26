package Test.dao;

import Test.domain.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemsDao {

    public List<Item> findAll() throws SQLException, ClassNotFoundException;
}
