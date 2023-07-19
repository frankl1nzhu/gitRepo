package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    Emp getEmpById(@Param("empId") Integer empId);
}
