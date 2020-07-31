package com.way.employeeservice.service;

import com.way.employeeservice.dao.entity.Employees;
import com.way.employeeservice.param.EmployeeByIdParam;
import com.way.employeeservice.param.PageParam;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
public interface EmployeeService {
    List<Employees> getAllEmployees(PageParam param);

    Employees getEmployeeById(EmployeeByIdParam param);
}
