package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.atguigu.mybatis.bean.Emp;
import com.atguigu.mybatis.bean.EmpExample;
import com.atguigu.mybatis.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author yang
 * @date 2024/04/12
 */
public class MBGTest {
    @Test
    public void testMBG(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            //List<Emp> list = mapper.selectByExample(null);
            //list.forEach(emp -> {
            //    System.out.println(emp);
            //});
            //根据条件查询
            //EmpExample empExample = new EmpExample();
            //empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            //empExample.or().andDidIsNotNull();
            //List<Emp> list = mapper.selectByExample(empExample);
            //list.forEach(emp -> {System.out.println(emp);});
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com",3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
