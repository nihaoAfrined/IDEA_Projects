package wxy.dao;

import org.apache.ibatis.annotations.Select;
import wxy.domain.QueryVo;
import wxy.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
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
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据queryvo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 可能是各种查询条件
     * @return
     */
    List<User> findUserByCondition(User user);

}