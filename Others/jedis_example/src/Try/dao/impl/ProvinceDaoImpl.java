package Try.dao.impl;

import Try.dao.ProvinceDao;
import Try.domain.Province;
import Try.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl  implements ProvinceDao {

    //声明一个成员变量 jdbctemplement
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());   //JdbcTemplate 查询数据库


    @Override
    public List<Province> findAll() {
        //定义sql
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
