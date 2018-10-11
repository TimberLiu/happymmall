package com.mmall.dao;

import com.mmall.pojo.OrderItem;

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
}