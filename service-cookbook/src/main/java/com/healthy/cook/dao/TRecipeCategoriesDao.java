package com.healthy.cook.dao;

import com.gugu.entity.RecipeCategories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (RecipeCategories)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-06 21:57:24
 */
@Mapper
public interface TRecipeCategoriesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RecipeCategories queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param RecipeCategories 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RecipeCategories> queryAllByLimit(RecipeCategories RecipeCategories, @Param("pageable") Pageable pageable);
    List<RecipeCategories> getTypeAll();
    /**
     * 统计总行数
     *
     * @param RecipeCategories 查询条件
     * @return 总行数
     */
    long count(RecipeCategories RecipeCategories);

    /**
     * 新增数据
     *
     * @param RecipeCategories 实例对象
     * @return 影响行数
     */
    int insert(RecipeCategories RecipeCategories);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RecipeCategories> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RecipeCategories> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RecipeCategories> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RecipeCategories> entities);

    /**
     * 修改数据
     *
     * @param RecipeCategories 实例对象
     * @return 影响行数
     */
    int update(RecipeCategories RecipeCategories);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

