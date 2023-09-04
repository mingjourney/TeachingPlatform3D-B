package com.healthy.heathy.dao;

import com.healthy.dto.DateDataForm;
import com.healthy.dto.SportItem;
import com.healthy.entity.SportType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Gugu
 * @create 2023-04-29 8:26
 * @purpose
 */
@Mapper
public interface RecordMapper {
    @Insert("insert into t_body(user_id,weight,time) values(#{userid},#{weight},NOW())")
    int saveWeightDate(@Param("weight") Double weight,@Param("userid") Integer useid);


    int saveDateData(@Param("data") DateDataForm data,@Param("userid") Integer userid);

    int saveSports(List<SportItem> sports,Integer userid);

    List<SportType> getSports();
}
