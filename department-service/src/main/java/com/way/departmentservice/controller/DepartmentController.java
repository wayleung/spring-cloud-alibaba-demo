package com.way.departmentservice.controller;

import com.way.departmentservice.dao.entity.Departments;
import com.way.departmentservice.param.DepartmentByIdParam;
import com.way.departmentservice.param.PageParam;
import com.way.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
@RequestMapping("/department-msc")
@MapperScan("com.way.departmentservice.dao")
@EnableDiscoveryClient
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getAllDepartments")
    List<Departments> getAllDepartments(@RequestBody PageParam param){
        return departmentService.getAllDepartments(param);
    }

    @RequestMapping("/getDepartmentById")
    Departments getDepartmentById(@RequestBody DepartmentByIdParam param){
        return departmentService.getDepartmentById(param);
    }


}
