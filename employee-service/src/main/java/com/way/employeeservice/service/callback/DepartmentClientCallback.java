package com.way.employeeservice.service.callback;

import com.way.employeeservice.service.client.DepartmentClient;
import com.way.employeeservice.service.entity.Departments;
import com.way.employeeservice.service.param.DepartmentByIdParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@Component
public class DepartmentClientCallback implements DepartmentClient {

    @Override
    public Departments getDepartmentById(DepartmentByIdParam param) {
        Departments departments = new Departments();
        departments.setDeptName("feign hystrix熔断：Departments服务查询失败，请稍后再试");
        departments.setDeptNo("feign hystrix熔断：Departments服务查询失败，请稍后再试");
        return departments;
    }
}
