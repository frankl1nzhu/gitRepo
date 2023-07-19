package com.mybatis.mapper;

import com.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    //分步查询第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);
    //分步查询
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
