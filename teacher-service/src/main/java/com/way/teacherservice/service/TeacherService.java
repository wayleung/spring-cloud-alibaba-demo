package com.way.teacherservice.service;

import com.way.teacherservice.dao.entity.Classes;
import com.way.teacherservice.dao.entity.Teacher;

import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
public interface TeacherService {
    List<Teacher> getAllTeachers();

    List<Classes> getAllClasses();
}
