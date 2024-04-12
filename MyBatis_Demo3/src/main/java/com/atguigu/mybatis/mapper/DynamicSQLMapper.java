package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/11
 */
public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose,when ,otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);
    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    /**
     * 通过List实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
