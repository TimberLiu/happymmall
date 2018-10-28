package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface OrderItemMapper {

    /**
     * 根据订单详情项 Id 删除订单详情
     * @param id 订单详情 Id
     * @return int 删除的数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入订单详情项
     * @param orderItem 订单详情项对象
     * @return int 插入的数量
     */
    int insert(OrderItem orderItem);

    /**
     * 有选择地插入订单详情项
     * @param orderItem orderItem
     * @return int 插入的数量
     */
    int insertSelective(OrderItem orderItem);

    /**
     * 根据订单详情项 Id 查询订单详情项
     * @param id 订单详情项 Id
     * @return int
     */
    OrderItem selectByPrimaryKey(Integer id);

    /**
     * 有选择地更新订单详情项
     * @param orderItem orderItem
     * @return int
     */
    int updateByPrimaryKeySelective(OrderItem orderItem);

    /**
     * 更新订单详情项
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