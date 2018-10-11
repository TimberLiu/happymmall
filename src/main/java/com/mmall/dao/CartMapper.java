package com.mmall.dao;

import com.mmall.pojo.Cart;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface CartMapper {

    /**
     * delete cart by cartId
     * @param id cartId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert cart
     * @param cart cart
     * @return int
     */
    int insert(Cart cart);

    /**
     * insert cart selectively
     * @param cart cart
     * @return int
     */
    int insertSelective(Cart cart);

    /**
     * select cart by cartId
     * @param id cartId
     * @return Cart
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * update cart by cart selectively
     * @param cart cart
     * @return int
     */
    int updateByPrimaryKeySelective(Cart cart);

    /**
     * update cart by cart
     * @param cart cart
     * @return int
     */
    int updateByPrimaryKey(Cart cart);
}