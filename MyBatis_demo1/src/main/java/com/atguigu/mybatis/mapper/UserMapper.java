package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.pojo.User;

/**
 * @author yang
 * @date 2024/04/07
 */
public interface UserMapper {
    /**
     * Mybatis面向接口编程的两个一致：
     * 1.映射接口文件的namespace要和映射接口的全类名保持一致
     * 2.映射文件中SQL语句的id要和mapper接口中的方法名保持一致
     *
     * 表--实体类--mapper接口--映射文件
     */
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getAllUser();
}
