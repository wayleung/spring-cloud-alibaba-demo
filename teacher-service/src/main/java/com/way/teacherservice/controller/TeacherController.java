package com.way.teacherservice.controller;

import com.way.teacherservice.dao.entity.Classes;
import com.way.teacherservice.dao.entity.Student;
import com.way.teacherservice.service.TeacherService;
import com.way.teacherservice.dao.entity.Teacher;
import com.way.teacherservice.service.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
@RestController
@RequestMapping("/teacher-service")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    StudentClient studentClient;

//    http://localhost:8880/teacher-service/students
//    @GetMapping("/students")
//    public String getAllStudents(){
//        return restTemplate.getForObject("http://student-service/student-service/students",String.class);
//    }

    //    http://localhost:8880/teacher-service/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentClient.getAllStudents();
    }


//    http://localhost:8880/teacher-service/student/1
    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable("id") Integer id){
        return studentClient.getStudentById(id);
    }

    @GetMapping("/teachers")
    List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/classes")
    List<Classes> getAllClasses(){
        return teacherService.getAllClasses();
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
}
