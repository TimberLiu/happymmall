package com.mmall.dao;

import com.mmall.pojo.User;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface UserMapper {

    /**
     * delete user by userId
     * @param id userId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert user
     * @param user user
     * @return int
     */
    int insert(User user);

    /**
     * insert user selectively
     * @param user user
     * @return int
     */
    int insertSelective(User user);

    /**
     * select user by userId
     * @param id userId
     * @return User
     */
    User selectByPrimaryKey(Integer id);

    /**
     * update user by userId
     * @param user user
     * @return int
     */
    int updateByPrimaryKeySelective(User user);

    /**
     * update user by user
     * @param user user
     * @return int
     */
    int updateByPrimaryKey(User user);
}