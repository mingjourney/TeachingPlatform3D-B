package com.healthy.heathy.dao;

import com.healthy.dto.TargetForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Gugu
 * @create 2023-05-01 14:31
 * @purpose
 */
@Mapper
public interface TargetMapper {
    int addTarget(@Param("target") TargetForm target,@Param("goals") String goals,@Param("userid") Integer userid);
}
