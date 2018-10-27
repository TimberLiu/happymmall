package com.mmall.dao;

import com.mmall.pojo.Order;
import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface OrderMapper {

    /**
     * delete order by orderId
     * @param id orderId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert order
     * @param order order
     * @return int
     */
    int insert(Order order);

    /**
     * insert order selectively
     * @param order order
     * @return int
     */
    int insertSelective(Order order);

    /**
     * select order by orderId
     * @param id orderId
     * @return Order
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * update order by order selectively
     * @param order order
     * @return int
     */
    int updateByPrimaryKeySelective(Order order);

    /**
     * update order
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