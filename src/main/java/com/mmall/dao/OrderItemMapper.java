package com.mmall.dao;

import com.mmall.pojo.Order;
import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface OrderItemMapper {

    /**
     * delete orderItem by orderItemId
     * @param id orderId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert orderItem by orderItem
     * @param orderItem orderItem
     * @return int
     */
    int insert(OrderItem orderItem);

    /**
     * insert orderItem selectively
     * @param orderItem orderItem
     * @return int
     */
    int insertSelective(OrderItem orderItem);

    /**
     * select orderItem by orderId
     * @param id orderId
     * @return int
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * update orderItem by orderItem
     * @param orderItem orderItem
     * @return int
     */
    int updateByPrimaryKeySelective(OrderItem orderItem);

    /**
     * update orderItem by orderItem
     * @param orderItem orderItem
     * @return int
     */
    int updateByPrimaryKey(OrderItem orderItem);

    /**
     * 根据订单号和用户 Id 查询订单详情
     * @param orderNo 订单号
     * @param userId 用户 Id
     * @return List<OrderItem>
     */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo") Long orderNo, @Param("userId") Integer userId);

    /**
     * 根据订单号查询订单详情
     * @param orderNo 订单号
     * @return List<OrderItem>
     */
    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);

    /**
     * 批量插入
     * @param orderItemList 待插入的订单详情项集合
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);


}