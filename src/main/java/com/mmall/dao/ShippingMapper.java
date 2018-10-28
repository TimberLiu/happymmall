package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface ShippingMapper {

    /**
     * 根据收货地址 Id 删除收货地址
     * @param id shippingId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入收货地址
     * @param shipping shipping
     * @return int
     */
    int insert(Shipping shipping);

    /**
     * 有选择地插入收货地址
     * @param shipping shipping
     * @return int
     */
    int insertSelective(Shipping shipping);

    /**
     * 根据收货地址 Id 查询收货地址
     * @param id shippingId
     * @return Shipping
     */
    Shipping selectByPrimaryKey(Integer id);

    /**
     * 有选择地更新收货地址
     * @param shipping shipping
     * @return int
     */
    int updateByPrimaryKeySelective(Shipping shipping);

    /**
     * 更新收货地址
     * @param shipping shipping
     * @return int
     */
    int updateByPrimaryKey(Shipping shipping);

    /**
     * 根据用户 Id 和收货地址 Id 删除收货地址
     * @param userId 用户 Id
     * @param shippingId 收货地址 Id
     * @return int 删除行数
     */
    int deleteByShippingIdUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 根据用户 Id 和 Shipping 更新收货地址信息
     * @param shipping Shipping
     * @return int
     */
    int updateByShipping(Shipping shipping);

    /**
     * 根据用户 Id 和收货地址 Id 查询信息
     * @param userId 用户 Id
     * @param shippingId 收货地址 Id
     * @return Shipping
     */
    Shipping selectByUserIdShippingId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    /**
     * 根据用户 Id 查询所有信息
     * @param userId 用户 Id
     * @return List<Shipping>
     */
    List<Shipping> selectByUserId(Integer userId);


}