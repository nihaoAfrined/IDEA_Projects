package wxy.dao;

import wxy.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);
}