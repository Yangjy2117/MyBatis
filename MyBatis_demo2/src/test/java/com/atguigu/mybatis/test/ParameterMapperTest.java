package com.atguigu.mybatis.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
/**
 * @author yang
 * @date 2024/04/09
 */
public class ParameterMapperTest {
    /**
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * Mybatis获取参数值的各种方法:
     * 1.mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的字符串获取参数值，但是需要注意${}的单引号问题
     * 2.mapper接口方法的参数为多个时
     * 此时Mybatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以arg0,arg1...为键，以参数为值
     * b>以param1,param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3.若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4.mapper接口方法的参数是实体类类型的参数
     * 只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5.使用@Param注解命名参数
     */
    @Test
    public void testcheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }
    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.getUserByUsername("admin");
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list =mapper.getAllUser();
        list.forEach(user-> System.out.println(user));
    }
    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user=mapper.checkLogin("admin","123456");
        System.out.println(user);
    }
    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testinsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null,"李四","123",23,"男","123@qq.com"));
        System.out.println(result);
    }
}
