package com.way.teacherservice.service.client;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-02
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.way.teacherservice.dao.entity.Classes;
import com.way.teacherservice.dao.entity.Student;
import com.way.teacherservice.service.fallback.StudentClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "student-service",fallback = StudentClientFallback.class)
public interface StudentClient {
    @GetMapping("/student-service/students")
//    @SentinelResource(value="getAllStudents")
    List<Student> getAllStudents();

    @GetMapping(value="/student-service/student/{id}")
//    @SentinelResource("getStudentById")
    Student getStudentById(@PathVariable("id") Integer id);

    @GetMapping(value="/student-service/classes")
//    @SentinelResource("getAllClasses")
    List<Classes> getAllClasses();
}