package com.way.employeeservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.way.employeeservice.controller.vo.InfoVo;
import com.way.employeeservice.dao.entity.Employees;
import com.way.employeeservice.param.EmployeeByIdParam;
import com.way.employeeservice.param.PageParam;
import com.way.employeeservice.service.client.DepartmentClient;
import com.way.employeeservice.service.EmployeeService;
import com.way.employeeservice.service.entity.Departments;
import com.way.employeeservice.service.hystrix.DepartmentRestHystrixService;
import com.way.employeeservice.service.param.DepartmentByIdParam;
import com.way.employeeservice.util.NetworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@RestController
@RequestMapping("/employee-msc")
@MapperScan("com.way.employeeservice.dao")
public class EmployeeController {
    @Value("${server.port}")
    String port;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private DepartmentRestHystrixService departmentRestHystrixService;

    @RequestMapping("/getAllEmployees")
    @SentinelResource(value = "mployee-msc/getAllEmployees")
    List<Employees> getAllEmployees(@RequestBody PageParam param){
        return employeeService.getAllEmployees(param);
    }

    @RequestMapping("/getEmployeeById")
    @SentinelResource(value = "mployee-msc/getEmployeeById")
    Employees getEmployeeById(@RequestBody EmployeeByIdParam param){
        return employeeService.getEmployeeById(param);
    }


    @RequestMapping("/getAllDepartments")
    @SentinelResource(value = "mployee-msc/getAllDepartments")
    String getAllDepartments(@RequestBody JSONObject jsonObject){
        return departmentRestHystrixService.getAllDepartments(jsonObject);
    }


    @RequestMapping("/getDepartmentById")
    @SentinelResource(value = "mployee-msc/getDepartmentById")
    Departments getDepartmentById(@RequestBody DepartmentByIdParam param){
        /**
         * feign熔断需要在属性文件加上feign.hystrix.enabled=true
         *
         */
        return departmentClient.getDepartmentById(param);
    }


    @RequestMapping("/getInfo")
    @SentinelResource(value = "mployee-msc/getInfo")
    InfoVo getInfo(HttpServletRequest request){
        InfoVo vo = new InfoVo();
        vo.setServerPort(port);
        vo.setIpAddress(NetworkUtil.getIPAddress(request));
        return vo;
    }


    @RequestMapping("/getDepartmentServiceInfo")
    @SentinelResource(value = "mployee-msc/getDepartmentServiceInfo")
    InfoVo getDepartmentServiceInfo(HttpServletRequest request){
        return departmentClient.getInfo();
    }
}
