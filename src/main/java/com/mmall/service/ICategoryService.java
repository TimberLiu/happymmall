package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * 分类管理接口
 * @author Timber
 * @date 2018/10/13
 */
public interface ICategoryService {

    /**
     * 添加商品分类
     * @param categoryName 品类名
     * @param parentId 父结点 Id
     * @return ServerResponse
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新分类名称
     * @param categoryId 分类 Id
     * @param categoryName 分类名称
     * @return ServerResponse
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 根据分类 Id 查询子分类
     * @param categoryId 分类 Id
     * @return ServerResponse<List<Category>>
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    /**
     * 根据分类 Id 递归查询分类和子分类
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
