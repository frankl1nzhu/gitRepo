package com.mycom.ssm.service;

import com.github.pagehelper.PageInfo;
import com.mycom.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    /*查询所有的员工信息*/
    List<Employee> getAllEmployee();

    /*获取员工分页信息*/
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
