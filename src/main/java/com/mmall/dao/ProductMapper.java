package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface ProductMapper {

    /**
     * 根据商品 Id 删除商品
     * @param id productId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入商品
     * @param product product
     * @return int
     */
    int insert(Product product);

    /**
     * 有选择地插入商品
     * @param product product
     * @return int
     */
    int insertSelective(Product product);

    /**
     * 根据商品 Id 查询商品
     * @param id productId
     * @return Product
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * 有选择地更新商品
     * @param product product
     * @return int
     */
    int updateByPrimaryKeySelective(Product product);

    /**
     * 更新商品
     * @param product product
     * @return int
     */
    int updateByPrimaryKey(Product product);

    /**
     * 查询商品列表
     * @return List<Product>
     */
    List<Product> selectList();

    /**
     * 根据商品名称和商品 Id 查询商品
     * @param productName 产品名称
     * @param productId 商品 Id
     * @return List<Product>
     */
    List<Product> selectByNameAndProductId(@Param("productName") String productName, @Param("productId") Integer productId);

    /**
     * 根据商品名称和分类 Id 集合查询商品
     * @param productName 商品名称
     * @param categoryIdList 分类 Id 集合
     * @return List<Product>
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("categoryIdList") List<Integer> categoryIdList);

    /**
     * 根据商品 Id 查询库存
     * @param id 商品 Id
     * @return
     */
    Integer selectStockByProductId(Integer id);

}