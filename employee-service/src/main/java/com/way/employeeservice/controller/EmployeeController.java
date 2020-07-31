package com.way.employeeservice.controller;

import com.way.employeeservice.dao.entity.Employees;
import com.way.employeeservice.param.EmployeeByIdParam;
import com.way.employeeservice.param.PageParam;
import com.way.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@RestController
@RequestMapping("/employee-msc")
@MapperScan("com.way.employeeservice.dao")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getAllEmployees")
    List<Employees> getAllEmployees(@RequestBody PageParam param){
        return employeeService.getAllEmployees(param);
    }

    @RequestMapping("/getEmployeeById")
    Employees getEmployeeById(@RequestBody EmployeeByIdParam param){
        return employeeService.getEmployeeById(param);
    }


}
