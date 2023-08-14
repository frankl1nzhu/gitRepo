package com.faimdeloup.takeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.faimdeloup.takeout.entity.Employee;
import com.faimdeloup.takeout.mapper.EmployeeMapper;
import com.faimdeloup.takeout.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author Franklin
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
