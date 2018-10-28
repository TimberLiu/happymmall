package com.mmall.dao;

import com.mmall.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface OrderMapper {

    /**
     * 根据订单 Id 删除订单
     * @param id orderId
     * @return int 删除的数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入订单
     * @param order order
     * @return int 插入的数量
     */
    int insert(Order order);

    /**
     * 有选择地插入订单
     * @param order order
     * @return int 插入的数量
     */
    int insertSelective(Order order);

    /**
     * 根据订单 Id 查询订单
     * @param id orderId
     * @return Order 订单对象
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 有选择地更新订单
     * @param order order
     * @return int 更新的数量
     */
    int updateByPrimaryKeySelective(Order order);

    /**
     * 更新订单
     * @param order order
     * @return int
     */
    int updateByPrimaryKey(Order order);

    /**
     * 根据用户 Id 和订单号查询
     * @param userId 用户 Id
     * @param orderNo 订单号
     * @return Order 订单
     */
    Order selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    /**
     * 根据订单号查询订单
     * @param orderNo 订单号
     * @return 订单
     */
    Order selectByOrderNo(Long orderNo);

    /**
     * 根据用户 Id 查询所有订单
     * @param userId 用户 Id
     * @return List<Order>
     */
    List<Order> selectByUserId(Integer userId);

    /**
     * 查询所有订单
     * @return List<Order>
     */
    List<Order> selectAllOrder();

}