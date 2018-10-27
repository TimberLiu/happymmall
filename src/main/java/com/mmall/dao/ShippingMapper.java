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
     * delete shipping by shippingId
     * @param id shippingId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert shipping
     * @param shipping shipping
     * @return int
     */
    int insert(Shipping shipping);

    /**
     * insert shipping selectively
     * @param shipping shipping
     * @return int
     */
    int insertSelective(Shipping shipping);

    /**
     * select shipping by shippingId
     * @param id shippingId
     * @return Shipping
     */
    Shipping selectByPrimaryKey(Integer id);

    /**
     * update shipping by shipping selectively
     * @param shipping shipping
     * @return int
     */
    int updateByPrimaryKeySelective(Shipping shipping);

    /**
     * update shipping by shipping
     * @param shipping shipping
     * @return int
     */
    int updateByPrimaryKey(Shipping shipping);

    /**
     * 根据用户 Id 和收货地址 Id 删除
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