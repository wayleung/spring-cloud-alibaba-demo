package com.way.studentservice.controller;

import com.way.studentservice.dao.entity.Classes;
import com.way.studentservice.dao.entity.Student;
import com.way.studentservice.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
@RequestMapping("/student-service")
@RestController
@Log
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    List<Student> getAllStudents() {
        log.info("student.getAllStudents");
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable(name = "id") Integer id) {
        log.info("student.getStudentById");
        return studentService.getStudentById(id);
    }

    @GetMapping("/classes")
    List<Classes> getAllClasses() {
        log.info("student.getAllClasses");
        return studentService.getAllClasses();
    }
}
