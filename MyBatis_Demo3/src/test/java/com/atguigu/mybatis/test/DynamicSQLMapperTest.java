package com.atguigu.mybatis.test;

import java.util.Arrays;
import java.util.List;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author yang
 * @date 2024/04/11
 */
public class DynamicSQLMapperTest {
    /**
     * 动态SQL：
     * 1.if:根据标签中test属性对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2.where:
     *  当where标签中有内容时，会自动生成where关键字，并且将 内容前多余的and或or去掉
     *  当where标签中没有内容时，此时where标签没有任何作用
     *  注意:where标签不能将其中内容后面多余的and或or去掉
     * 3.trim:
     *  prefix/suffix:将trim标签中内容前面或后面添加指定内容
     *  prefixOverrides/suffixOverrides:将trim标签中内容前面或后面去掉指定内容
     *  若标签中没有任何内容时，trim标签也没任何效果
     * 4.choose,when,otherwise,相当于if...else if...else
     * when至少有一个，ohterwise至多有一个
     * 5.foreach
     *  collection:设置需要循环的数组或集合
     *  item:表示数组或集合中的每一个数据
     *  separator:循环体之间的分隔符
     *  open:foreach标签所循环的所有内容的开始符
     *  close:foreach标签所循环的所有内容的结束符
     * 6.sql标签
     *  设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     *  引用SQL片段：<include refid="empColumns"></include>
     */
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com");
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com");
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1,emp2,emp3);
        System.out.println(mapper.insertMoreByList(emps));
    }
    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6,7,8});
        System.out.println(result);
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null,"张三" ,23 ,"男","123@qq.com"));
        System.out.println(list);
    }
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlsession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlsession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null,"" ,null ,"",null));
        System.out.println(list);
    }

}
