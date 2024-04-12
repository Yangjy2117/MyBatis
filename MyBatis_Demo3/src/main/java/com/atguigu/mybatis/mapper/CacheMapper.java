package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/11
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
