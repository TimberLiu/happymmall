package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

public interface IOrderService {

    /**
     * 支付
     * @param orderNo 订单号
     * @param userId 用户 Id
     * @param path 二维码存放路径
     * @return ServerResponse
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     * 支付宝回调
     * @param params 参数
     * @return ServerResponse
     */
    ServerResponse alipayCallback(Map<String, String> params);

    /**
     * 查询订单支付状态
     * @param userId 用户 Id
     * @param orderNo 订单号
     * @return ServerResponse<Boolean>
     */
    ServerResponse<Boolean> queryOrderPayStatus(Integer userId, Long orderNo);

    /**
     * 创建订单
     * @param userId 用户 Id
     * @param shippingId 收货地址 Id
     * @return ServerResponse
     */
    ServerResponse createOrder(Integer userId, Integer shippingId);

    /**
     * 取消订单
     * @param userId 用户 Id
     * @param orderNo  订单号
     * @return ServerResponse<String>
     */
    ServerResponse<String> cancel(Integer userId, Long orderNo);

    /**
     * 从购物车中点击生成订单时得到产品的详情
     * @param userId 用户 Id
     * @return ServerResponse
     */
    ServerResponse getOrderCartProduct(Integer userId);

    /**
     * 得到订单详情
     * @param userId 用户 Id
     * @param orderNo 订单号
     * @return ServerResponse<OrderVo>
     */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    /**
     * 查询用户的所有订单
     * @param userId 用户 Id
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);

    /**
     * 管理员查询订单列表
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> manageList(Integer pageNum, Integer pageSize);

    /**
     * 管理员查询订单详情
     * @param orderNo 订单号
     * @return ServerResponse<OrderVo>
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    /**
     * 管理员搜索订单详情
     * @param orderNo 订单号
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    /**
     * 产品发货
     * @param orderNo 订单号
     * @return ServerResponse
     */
    ServerResponse manageSendGoods(Long orderNo);

}
