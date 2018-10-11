package com.mmall.dao;

import com.mmall.pojo.Order;

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
}