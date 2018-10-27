package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * 用户服务接口
 * @author Timber
 * @date 2018/10/12
 */

public interface IUserService {

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码，MD5 加密
     * @return ServerResponse<User>
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     * @param user 用户对象
     * @return ServerResponse<String>
     */
    ServerResponse<String> register(User user);

    /**
     * 校验信息有效性
     * @param str 具体数据
     * @param type 校验何种类型的数据
     * @return ServerResponse<String>
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 查询找回密码的提示问题
     * @param username 用户名
     * @return ServerResponse<String>
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 校验问题回答是否正确
     * @param username 用户名
     * @param question 问题
     * @param answer 答案
     * @return ServerResponse<String>
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 忘记密码中的重置密码
     * @param username 用户名
     * @param newPassword 新密码
     * @param forgetToken token
     * @return ServerResponse<String>
     */
    ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    /**
     * 登录状态下重置密码
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param user 用户信息
     * @return ServerResponse<String>
     */
    ServerResponse<String> resetPassword(String oldPassword, String newPassword, User user);

    /**
     * 更新用户信息
     * @param user 用户
     * @return ServerResponse<String>
     */
    ServerResponse<User> updateUserInfo(User user);

    /**
     * 根据用户 Id 得到用户信息
     * @param userId 用户 Id
     * @return ServerResponse<User>
     */
    ServerResponse<User> getInformation(Integer userId);

    /**
     * 校验管理员角色
     * @param user 用户
     * @return ServerResponse
     */
    ServerResponse checkAdminRole(User user);

}
