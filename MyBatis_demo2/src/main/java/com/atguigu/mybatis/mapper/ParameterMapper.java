package com.atguigu.mybatis.mapper;

import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/09
 */
public interface ParameterMapper {
    /**
     * 添加用户信息
     */
    int insertUser(User user);
    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();
    User getUserByUsername(String Username);
    User checkLogin(String username,String password);
    User checkLoginByMap(Map<String,Object> map);
    /**
     * 验证登录(使用@param)
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
