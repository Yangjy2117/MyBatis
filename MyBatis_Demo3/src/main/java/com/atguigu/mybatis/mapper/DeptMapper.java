package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/10
 */
public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及员工所对应部门的信息
     * 分步查询第二步：通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
