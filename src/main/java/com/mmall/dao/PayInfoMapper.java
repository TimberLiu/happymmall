package com.mmall.dao;

import com.mmall.pojo.PayInfo;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface PayInfoMapper {

    /**
     * 根据支付信息的 Id 删除订单信息
     * @param id 订单信息 Id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入订单信息
     * @param payInfo payInfo
     * @return int
     */
    int insert(PayInfo payInfo);

    /**
     * 有选择地插入支付信息
     * @param payInfo payInfo
     * @return int
     */
    int insertSelective(PayInfo payInfo);

    /**
     * 根据支付信息 Id 查询
     * @param id payInfoId
     * @return PayInfo
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * 有选择地更新支付信息
     * @param payInfo payInfo
     * @return int
     */
    int updateByPrimaryKeySelective(PayInfo payInfo);

    /**
     * 更新支付信息
     * @param payInfo payInfo
     * @return int
     */
    int updateByPrimaryKey(PayInfo payInfo);
}