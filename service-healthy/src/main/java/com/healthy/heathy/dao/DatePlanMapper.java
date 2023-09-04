package com.healthy.heathy.dao;

import com.healthy.entity.DatePlan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DatePlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DatePlan record);

    int insertSelective(DatePlan record);

    DatePlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DatePlan record);

    int updateByPrimaryKey(DatePlan record);
    DatePlan getDatePlanToday(Integer userid);
}