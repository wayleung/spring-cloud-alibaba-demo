package com.way.studentservice.service;

import com.way.studentservice.dao.ClassesMapper;
import com.way.studentservice.dao.StudentMapper;
import com.way.studentservice.dao.entity.Classes;
import com.way.studentservice.dao.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ClassesMapper classesMapper;

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Classes> getAllClasses() {
        return classesMapper.selectAll();
    }
}
