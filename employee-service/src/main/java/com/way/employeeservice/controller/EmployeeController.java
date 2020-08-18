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
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@RestController
@RequestMapping("/employee-msc")
@MapperScan("com.way.employeeservice.dao")
@Slf4j
public class EmployeeController {
    @Value("${server.port}")
    String port;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private DepartmentRestHystrixService departmentRestHystrixService;

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/getAllEmployees")
    @SentinelResource(value = "employee-msc/getAllEmployees")
    List<Employees> getAllEmployees(@RequestBody PageParam param){
        return employeeService.getAllEmployees(param);
    }

    @RequestMapping("/getEmployeeById")
    @SentinelResource(value = "employee-msc/getEmployeeById")
    Employees getEmployeeById(@RequestBody EmployeeByIdParam param){
        return employeeService.getEmployeeById(param);
    }


    @RequestMapping("/getAllDepartments")
    @SentinelResource(value = "employee-msc/getAllDepartments")
    String getAllDepartments(@RequestBody JSONObject jsonObject){
        return departmentRestHystrixService.getAllDepartments(jsonObject);
    }


    @RequestMapping("/getDepartmentById")
    @SentinelResource(value = "employee-msc/getDepartmentById")
    Departments getDepartmentById(@RequestBody DepartmentByIdParam param){
        /**
         * feign熔断需要在属性文件加上feign.hystrix.enabled=true
         *
         */
        return departmentClient.getDepartmentById(param);
    }


    @RequestMapping("/getInfo")
    @SentinelResource(value = "employee-msc/getInfo")
    InfoVo getInfo(HttpServletRequest request){
        InfoVo vo = new InfoVo();
        vo.setServerPort(port);
        vo.setIpAddress(NetworkUtil.getIPAddress(request));
        return vo;
    }


    @RequestMapping("/getDepartmentServiceInfo")
    @SentinelResource(value = "employee-msc/getDepartmentServiceInfo")
    InfoVo getDepartmentServiceInfo(HttpServletRequest request){
        return departmentClient.getInfo();
    }

    @RequestMapping("/getLock")
    @SentinelResource(value = "employee-msc/getLock")
    public void getLock() {
        RLock lock = redissonClient.getLock("myLock");
        lock.lock(10, TimeUnit.SECONDS);
        log.info("lock");
//        lock.unlock();
//        log.info("unlock");
    }
}
