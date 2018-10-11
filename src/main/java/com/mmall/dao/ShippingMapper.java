package com.mmall.dao;

import com.mmall.pojo.Shipping;

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
}