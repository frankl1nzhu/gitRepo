package com.mycom.ssm.mapper;

import com.mycom.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    /*查询所有员工信息*/
    List<Employee> getAllEmployee();
}