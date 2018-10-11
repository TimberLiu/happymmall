package com.mmall.dao;

import com.mmall.pojo.Category;

/**
 * @author Timber
 * @date 2018/10/11
 */

public interface CategoryMapper {

    /**
     * delete category by categoryId
     * @param id categoryId
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert category
     * @param category
     * @return int
     */
    int insert(Category category);

    /**
     * insert category selectively
     * @param category category
     * @return int
     */
    int insertSelective(Category category);

    /**
     * select category by categoryId
     * @param id categoryId
     * @return Category
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * update category by category selectively
     * @param category category
     * @return int
     */
    int updateByPrimaryKeySelective(Category category);

    /**
     * update category by category
     * @param category category
     * @return int
     */
    int updateByPrimaryKey(Category category);
}