package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/09
 */
public interface SelectMapper  {
    /**
     * 根据id查询用户信息
     */
    List<User> getUserById(@Param("id") Integer id);

    Integer getCount();
    /**
     * 根据id查询用户信息为map格式
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
    /**
     * 查询所有用户信息为map格式
     */
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
