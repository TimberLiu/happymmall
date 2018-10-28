package com.mmall.dao;

import com.mmall.pojo.Category;

import java.util.List;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface CategoryMapper {

    /**
     * 根据分类 Id 删除分类
     * @param id 分类 Id
     * @return int 删除的数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入分类
     * @param category 分类对象
     * @return int 插入的数量
     */
    int insert(Category category);

    /**
     * 有选择地插入分类
     * @param category 分类对象
     * @return int 插入的数量
     */
    int insertSelective(Category category);

    /**
     * 根据分类 Id 查询分类
     * @param id 分类 Id
     * @return Category 分类对象
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * 根据分类有选择地更新分类
     * @param category 分类
     * @return int 更新的数量
     */
    int updateByPrimaryKeySelective(Category category);

    /**
     * 更新分类
     * @param category 分类对象
     * @return int 更新的数量
     */
    int updateByPrimaryKey(Category category);

    /**
     * 根据父结点 Id 查询子结点分类
     * @param parentId 父结点 Id
     * @return List<Category>
     */
    List<Category> getChildrenCategoryByParentId(Integer parentId);

}