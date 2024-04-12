package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/09
 */
public interface SQLMapper {
    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);
    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);
    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tablename") String tablename);
    /**
     * 添加用户信息
     */
    void insertUser(User user);
}
