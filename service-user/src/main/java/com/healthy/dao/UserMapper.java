package com.healthy.dao;

import com.healthy.dto.SignInForm;
import com.healthy.dto.UserLoginForm;
import org.apache.ibatis.annotations.*;

/**
 * @author Gugu
 * @create 2023-04-24 11:07
 * @purpose
 */
@Mapper
public interface UserMapper {

    UserLoginForm getUserLoginForm(@Param("email") String email,@Param("mobile") String mobile);

    @Select("select count(*) from t_user where email = #{email} or mobile = #{mobile}")
    int haveUser(@Param("email") String email,@Param("mobile") String mobile);

    int signIn(@Param("email") String email,@Param("mobile") String mobile,@Param("password")String password);

    SignInForm getUserInfo(Integer id);

    @Update("update t_user set password = #{password} where id = #{id}")
    int updatePassword(@Param("password") String password,@Param("id") Integer id);

    @Update("update t_user set weight=#{weight} where id = #{id}")
    int saveWeight(@Param("weight") Double weight,@Param("id") Integer id);

    int saveUserInfo(@Param("user") SignInForm user,@Param("id") Integer id);


}
