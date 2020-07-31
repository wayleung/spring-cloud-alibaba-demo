package com.way.employeeservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.way.employeeservice.dao.EmployeeMapper;
import com.way.employeeservice.dao.entity.Employees;
import com.way.employeeservice.param.EmployeeByIdParam;
import com.way.employeeservice.param.PageParam;
import com.way.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employees> getAllEmployees(PageParam param){
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        return employeeMapper.selectAll();
    }

    @Override
    public Employees getEmployeeById(EmployeeByIdParam param){
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        return employeeMapper.selectByPrimaryKey(param.getEmpNo());
    }
}
