package com.mycom.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycom.ssm.mapper.EmployeeMapper;
import com.mycom.ssm.pojo.Employee;
import com.mycom.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据        navigatePage为导航分页，即选择页面处的选项数
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }
}
