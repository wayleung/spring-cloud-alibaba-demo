package com.way.employeeservice.service.client;

import com.way.employeeservice.controller.vo.InfoVo;
import com.way.employeeservice.service.callback.DepartmentClientCallback;
import com.way.employeeservice.service.entity.Departments;
import com.way.employeeservice.service.param.DepartmentByIdParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@FeignClient(name = "department-service",fallback = DepartmentClientCallback.class)
public interface DepartmentClient {
    @RequestMapping("/department-msc/getDepartmentById")
    Departments getDepartmentById(DepartmentByIdParam param);

    @RequestMapping("/department-msc/getInfo")
    InfoVo getInfo();
}
