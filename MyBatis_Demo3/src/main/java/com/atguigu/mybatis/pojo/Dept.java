package com.atguigu.mybatis.pojo;

import java.util.List;

/**
 * @author yang
 * @date 2024/04/10
 */
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
            "did=" + did +
            ", deptName='" + deptName + '\'' +
            ", emps=" + emps +
            '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
