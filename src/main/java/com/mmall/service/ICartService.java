package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * @author Timber
 * @date 2018/10/15
 */

public interface ICartService {

    /**
     * 查询购物车所有商品
     * @param userId 用户 Id
     * @return ServerResponse<CartVo>
     */
    ServerResponse<CartVo> list(Integer userId);

    /**
     * 添加购物车
     * @param userId 用户 Id
     * @param productId 产品 Id
     * @param count 添加产品数量
     * @return ServerResponse<CartVo>
     */
    ServerResponse<CartVo> addCart(Integer userId, Integer productId, Integer count);

    /**
     * 更新购物车商品
     * @param userId 用户 Id
     * @param productId 产品 Id
     * @param count 添加产品数量
     * @return ServerResponse<CartVo>
     */
    ServerResponse<CartVo> updateCart(Integer userId, Integer productId, Integer count);

    /**
     * 删除购物车中商品
     * @param userId 用户 Id
     * @param productIds 商品 Id 集合
     * @return ServerResponse<CartVo>
     */
    ServerResponse<CartVo> deleteCart(Integer userId, String productIds);

    /**
     * 全选或全不选
     * @param userId 用户 Id
     * @param checked 选或不选
     * @param productId 商品 Id
     * @return ServerResponse<CartVo>
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer checked, Integer productId);

    /**
     * 查询购物车中商品数量
     * @param userId 用户 Id
     * @return ServerResponse<Integer>
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);

}
