package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author yang
 * @date 2024/04/12
 */
public class PageHelperTest {
    /**
     * limit index,pageSize
     * index：当前页的起始索引
     * pageSize:每页显示的条数
     * pageNum:当前页的页码
     * index = (pageNum-1)*pageSize
     *
     * 使用Mybatis的分页插件实现分页功能
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum, int pageSize);
     */
    @Test
    public void testPageHelper(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //Page<Object> page =PageHelper.startPage(2,4);

            List<Emp> list = mapper.selectByExample(null);
            list.forEach(emp-> System.out.println(emp));
            PageInfo<Emp> page = new PageInfo<>(list,5);
            System.out.println(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
