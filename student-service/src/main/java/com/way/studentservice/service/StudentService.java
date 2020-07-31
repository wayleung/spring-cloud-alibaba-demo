package com.way.studentservice.service;

import com.way.studentservice.dao.entity.Classes;
import com.way.studentservice.dao.entity.Student;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    List<Classes> getAllClasses();
}
