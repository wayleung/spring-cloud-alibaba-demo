package com.way.employeeservice.service.client;

import com.way.employeeservice.service.entity.Departments;
import com.way.employeeservice.service.param.DepartmentByIdParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@FeignClient(name = "department-service")
public interface DepartmentClient {
    @RequestMapping("/department-msc/getDepartmentById")
    Departments getDepartmentById(DepartmentByIdParam param);
}
