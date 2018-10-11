package com.mmall.dao;

import com.mmall.pojo.PayInfo;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface PayInfoMapper {

    /**
     * delete payInfo by payInfoId
     * @param id payInfoId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert payInfo
     * @param payInfo payInfo
     * @return int
     */
    int insert(PayInfo payInfo);

    /**
     * insert payInfo selectively
     * @param payInfo payInfo
     * @return int
     */
    int insertSelective(PayInfo payInfo);

    /**
     * select payInfo by payInfoId
     * @param id payInfoId
     * @return PayInfo
     */
    PayInfo selectByPrimaryKey(Integer id);

    /**
     * update payInfo by payInfo selectively
     * @param payInfo payInfo
     * @return int
     */
    int updateByPrimaryKeySelective(PayInfo payInfo);

    /**
     * update payInfo
     * @param payInfo payInfo
     * @return int
     */
    int updateByPrimaryKey(PayInfo payInfo);
}