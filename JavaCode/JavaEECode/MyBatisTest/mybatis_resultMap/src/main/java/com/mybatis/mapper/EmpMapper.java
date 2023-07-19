package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") int empid);
    Emp getEmpAndDeptByEmpId(@Param("empId") int empid);
    //分步查询
    Emp getEmpAndDeptByStepOne(@Param("empId") int empId);

    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") int deptId);
}
