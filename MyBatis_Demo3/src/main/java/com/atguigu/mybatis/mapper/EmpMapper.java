package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2024/04/10
 */
public interface EmpMapper {
    /**
     * 获取所有员工信息
     */
    List<Emp> getAllEmp();
    /**
     * 查询员工以及员工所对应部门的信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);
    /**
     * 通过分步查询查询员工以及员工所对应部门的信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
