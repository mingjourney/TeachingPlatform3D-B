package com.healthy.cook.service.Impl;

import com.healthy.common.ResultResponse;
import com.healthy.cook.dao.TRecipeCategoriesDao;
import com.healthy.cook.service.CookBookService;
import com.healthy.entity.RecipeCategories;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gugu
 * @create 2023-05-06 21:47
 * @purpose
 */
@Service
public class CoolBookServiceImpl implements CookBookService {
    @Resource
    TRecipeCategoriesDao dao;
    @Override
    public ResultResponse getCookType() {
        List<RecipeCategories> typeAll = dao.getTypeAll();
        return ResultResponse.success("查询成功",typeAll);
    }
}
