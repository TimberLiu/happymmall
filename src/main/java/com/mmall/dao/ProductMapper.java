package com.mmall.dao;

import com.mmall.pojo.Product;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface ProductMapper {

    /**
     * delete product by productId
     * @param id productId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert product
     * @param product product
     * @return int
     */
    int insert(Product product);

    /**
     * insert product selectively
     * @param product product
     * @return int
     */
    int insertSelective(Product product);

    /**
     * select product by productId
     * @param id productId
     * @return Product
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * update product by product selectively
     * @param product product
     * @return int
     */
    int updateByPrimaryKeySelective(Product product);

    /**
     * update product by product
     * @param product product
     * @return int
     */
    int updateByPrimaryKey(Product product);
}