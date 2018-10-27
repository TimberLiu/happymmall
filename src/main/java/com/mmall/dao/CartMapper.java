package com.mmall.dao;

import com.mmall.pojo.Cart;
import com.sun.tracing.dtrace.ProviderAttributes;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.util.List;

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

    /**
     * 根据用户 Id 和商品 Id 查询购物车
     * @param userId 用户 Id
     * @param productId 商品 Id
     * @return Cart
     */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 根据用户 Id 查询购物车
     * @param userId 用户 Id
     * @return List<Cart>
     */
    List<Cart> selectCartByUserId(Integer userId);

    /**
     * 根据用户 id 查询购物车中商品是否被选中
     * @param userId 用户 Id
     * @return int 未选中的数量
     */
    int selectCartProductCheckedStatusByUserId(Integer userId);

    /**
     * 根据用户 Id 和商品 Id 集合删除购物车中的商品
     * @param userId 用户 Id
     * @param productIds 商品 Id 集合
     * @return int 删除商品的数量
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIds") List<String> productIds);

    /**
     * 全选或全反选，单选或单反选
     * @param userId 用户 Id
     * @param checked 选或不选
     * @param productId 商品 Id
     * @return 修改的数量
     */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId, @Param("checked") Integer checked, @Param("productId")Integer productId);

    /**
     * 查询购物车商品数量
     * @param userId 用户 Id
     * @return int 商品数量
     */
    int selectCartProductCount(Integer userId);

    /**
     * 根据用户 Id 查询已经勾选的购物车
     * @param userId 用户 Id
     * @return List<Cart>
     */
    List<Cart> selectCheckedCartByUserId(Integer userId);

}