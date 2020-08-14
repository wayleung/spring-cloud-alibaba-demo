package com.way.departmentservice.service;

import com.way.departmentservice.dao.entity.Departments;
import com.way.departmentservice.param.DepartmentByIdParam;
import com.way.departmentservice.param.PageParam;

import java.util.List;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
public interface DepartmentService {
    List<Departments> getAllDepartments(PageParam param);

    Departments getDepartmentById(DepartmentByIdParam param);
}
