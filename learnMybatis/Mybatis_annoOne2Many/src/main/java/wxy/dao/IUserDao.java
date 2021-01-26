package wxy.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import wxy.domain.User;

import java.util.List;

/**
 * 在mybatis中，针对CRUD一共有四个注解
 * @Select @INSERT @UPDATE @DELETE
 */

@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap" ,value={
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "wxy.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();


    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value={"userMap"})
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     *
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap(value={"userMap"})
//    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);


}