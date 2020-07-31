package com.way.teacherservice.service.fallback;

import com.way.teacherservice.dao.entity.Classes;
import com.way.teacherservice.dao.entity.Student;
import com.way.teacherservice.service.client.StudentClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-03
 */
@Component
public class StudentClientFallback implements StudentClient {
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("返回学生失败");
        list.add(student);
        return list;
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = new Student();
        student.setId(1);
        student.setName("返回学生失败");
        return student;
    }

    @Override
    public List<Classes> getAllClasses() {
        List<Classes> list = new ArrayList<>();
        Classes classes = new Classes();
        classes.setId(1);
        classes.setName("返回班级失败");
        list.add(classes);
        return list;
    }
}
