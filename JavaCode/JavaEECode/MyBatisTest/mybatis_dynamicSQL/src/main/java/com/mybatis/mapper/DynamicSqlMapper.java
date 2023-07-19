package com.mybatis.mapper;

import com.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {

    List<Emp> getEmpByCondition(Emp emp);
    List<Emp> getEmpByChoose(Emp emp);
    void insertMoreEmp(@Param("emps") List<Emp> emps);
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
