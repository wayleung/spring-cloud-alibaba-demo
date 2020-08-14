package com.way.employeeservice.service.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-08-01
 */
@Service
public class DepartmentRestHystrixService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getAllDepartmentsError")
    public String getAllDepartments(JSONObject jsonObject){
        JSONObject json = new JSONObject();
        json.put("pageIndex", jsonObject.getInteger("pageIndex"));
        json.put("pageSize",jsonObject.getInteger("pageSize"));

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(json.toString(), headers);
        return restTemplate.postForEntity("http://department-service/department-msc/getAllDepartments",formEntity,String.class).getBody();
    }

    public String getAllDepartmentsError(JSONObject jsonObject){
        return "hystrix 熔断触发 稍后再试";
    }
}
