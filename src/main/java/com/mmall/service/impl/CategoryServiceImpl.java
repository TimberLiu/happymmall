package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 分类管理服务
 * @author Timber
 * @date 2018/10/13
 */

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if(parentId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("添加商品分类参数错误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        // true：分类可用 false：分类不可用
        category.setStatus(true);
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());

        int rowCount = categoryMapper.insertSelective(category);
        if(rowCount > 0) {
            return ServerResponse.createBySuccessMessage("添加分类成功");
        }
        return ServerResponse.createByErrorMessage("添加分类失败");
    }

    @Override
    public ServerResponse updateCategoryName(Integer categoryId, String categoryName) {
        if(categoryId == null || StringUtils.isBlank(categoryName)) {
            return ServerResponse.createByErrorMessage("修改分类名称参数错误");
        }
        Category newCategory = new Category();
        newCategory.setId(categoryId);
        newCategory.setName(categoryName);
        newCategory.setUpdateTime(new Date());

        int rowCount = categoryMapper.updateByPrimaryKeySelective(newCategory);
        if(rowCount > 0) {
            return ServerResponse.createBySuccessMessage("修改分类名称成功");
        }
        return ServerResponse.createByErrorMessage("修改分类名称失败");
    }

    @Override
    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categoryList = categoryMapper.getChildrenCategoryByParentId(categoryId);
        if(CollectionUtils.isEmpty(categoryList)) {
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }

    @Override
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId) {
        Set<Category> categorySet = Sets.newHashSet();

        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null) {
            categorySet.add(category);
        }
        findChildCategory(categorySet, categoryId);

        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null) {
            for (Category categoryItem: categorySet) {
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }

    /**
     * 递归查询子分类
     * @param categorySet 使用 set 保存分类信息，并防止重复
     * @param parentId 父分类 Id
     */
    private void findChildCategory(Set<Category> categorySet, Integer parentId) {
        List<Category> categoryList = categoryMapper.getChildrenCategoryByParentId(parentId);
        for (Category category: categoryList) {
            categorySet.add(category);
            findChildCategory(categorySet, category.getId());
        }
    }

}
