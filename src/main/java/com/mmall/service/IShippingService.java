package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

public interface IShippingService {

    /**
     * 新建地址
     * @param userId 用户 Id
     * @param shipping 收货地址信息
     * @return ServerResponse
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除收货地址
     * @param userId 用户 Id
     * @param shippingId 收货地址 Id
     * @return ServerResponse
     */
    ServerResponse del(Integer userId, Integer shippingId);

    /**
     * 根据用户 Id 更新收货地址
     * @param userId 用户 Id
     * @param shipping 收货地址信息
     * @return ServerResponse
     */
    ServerResponse update(Integer userId, Shipping shipping);

    /**
     * 根据用户 Id 和收货地址 Id 查询信息
     * @param userId 用户 Id
     * @param shippingId 收货地址 Id
     * @return ServerResponse
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    /**
     * 查询所有收货地址信息
     * @param userId 用户 Id
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);

}
