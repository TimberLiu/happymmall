package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * @author Timber
 * @date 2018/10/13
 */

public interface IProductService {

    /**
     * 保存或更新产品
     * @param product 产品
     * @return ServerResponse
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 设置商品状态
     * @param productId 商品 Id
     * @param status 要设置是商品状态
     * @return ServerResponse<String>
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    /**
     * 产品细节
     * @param productId 产品 Id
     * @return ServerResponse<ProductDetailVo>
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    /**
     * 获取产品列表
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return ServerResponse
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    /**
     * 根据商品名称或商品 Id 查询商品
     * @param productName 商品名称
     * @param productId 商品 Id
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    /**
     * 查询商品详情
     * @param productId 商品 Id
     * @return ServerResponse<ProductDetailVo>
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     * 根据关键字和分类 Id 查询商品
     * @param keyword 关键字
     * @param categoryId 分类 Id
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @param orderBy 顺序
     * @return ServerResponse<PageInfo>
     */
    ServerResponse<PageInfo> getProductByKeyWordCategory(String keyword, Integer categoryId, Integer pageNum, Integer pageSize, String orderBy);

}
