package com.way.teacherservice.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.way.teacherservice.dao.ClassesMapper;
import com.way.teacherservice.dao.TeacherMapper;
import com.way.teacherservice.dao.entity.Classes;
import com.way.teacherservice.dao.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ClassesMapper classesMapper;

    @Override
    @SentinelResource(value="getAllTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherMapper.selectAll();
    }

    @Override
    @SentinelResource(value="getAllClasses")
    public List<Classes> getAllClasses() {
        return classesMapper.selectAll();
    }
}
