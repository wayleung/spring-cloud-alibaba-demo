package com.way.departmentservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.way.departmentservice.controller.vo.InfoVo;
import com.way.departmentservice.dao.entity.Departments;
import com.way.departmentservice.param.DepartmentByIdParam;
import com.way.departmentservice.param.PageParam;
import com.way.departmentservice.service.DepartmentService;
import com.way.employeeservice.util.NetworkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.http.HttpServletRequest;
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

    @Value("${server.port}")
    String port;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getAllDepartments")
    @SentinelResource(value = "department-msc/getAllDepartments")
    List<Departments> getAllDepartments(@RequestBody PageParam param){
        return departmentService.getAllDepartments(param);
    }

    @RequestMapping("/getDepartmentById")
    @SentinelResource(value = "department-msc/getDepartmentById")
    Departments getDepartmentById(@RequestBody DepartmentByIdParam param){
        return departmentService.getDepartmentById(param);
    }

    @RequestMapping("/getInfo")
    @SentinelResource(value = "mployee-msc/getInfo")
    InfoVo getInfo(HttpServletRequest request){
        InfoVo vo = new InfoVo();
        vo.setServerPort(port);
        vo.setIpAddress(NetworkUtil.getIPAddress(request));
        return vo;
    }


}
