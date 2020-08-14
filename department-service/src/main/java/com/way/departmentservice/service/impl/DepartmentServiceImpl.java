package com.way.departmentservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.way.departmentservice.dao.DepartmentMapper;
import com.way.departmentservice.dao.entity.Departments;
import com.way.departmentservice.param.DepartmentByIdParam;
import com.way.departmentservice.param.PageParam;
import com.way.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Departments> getAllDepartments(PageParam param) {
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        return departmentMapper.selectAll();
    }

    @Override
    public Departments getDepartmentById(DepartmentByIdParam param) {
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        String deptNo = param.getDeptNo();
        return departmentMapper.selectByPrimaryKey(deptNo);
    }
}
