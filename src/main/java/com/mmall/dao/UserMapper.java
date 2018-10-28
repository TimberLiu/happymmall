package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface UserMapper {

    /**
     * 根据用户 Id 删除用户
     * @param id userId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户
     * @param user user
     * @return int
     */
    int insert(User user);

    /**
     * 有选择地插入用户
     * @param user user
     * @return int
     */
    int insertSelective(User user);

    /**
     * 根据用户 Id 查询用户
     * @param id userId
     * @return User
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据用户 Id 更新用户
     * @param user user
     * @return int
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * 更新用户
     * @param user user
     * @return int
     */
    int updateByPrimaryKey(User user);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return 查询到的用户数
     */
    int checkUsername(String username);

    /**
     * 检查 email 是否存在
     * @param email email
     * @return 查询到的用户数
     */
    int checkEmail(String email);

    /**
     * 验证密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return User
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 查询提示问题
     * @param username 用户名
     * @return 提示问题
     */
    String selectQuestionByUsername(String username);

    /**
     * 根据用户名检查问题的答案是否正确
     * @param username 用户名
     * @param question 提示问题
     * @param answer 答案
     * @return 查询到的数量
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    /**
     * 根据用户名更新密码
     * @param username 用户名
     * @param newPassword 新密码
     * @return int
     */
    int updatePasswordByUsername(@Param("username") String username, @Param("newPassword") String newPassword);

    /**
     * 验证密码是否正确
     * @param password 密码
     * @param userId 用户 Id
     * @return int
     */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    /**
     * 根据用户 Id 校验 email
     * @param email email
     * @param usrId userId
     * @return int
     */
    int checkEmailByUserId(@Param("email") String email, @Param("userId") Integer usrId);

}