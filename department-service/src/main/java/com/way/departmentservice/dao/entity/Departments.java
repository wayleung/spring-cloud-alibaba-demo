package com.way.departmentservice.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * departments
 * @author 
 */
@Data
public class Departments implements Serializable {
    private String deptNo;

    private String deptName;

    private static final long serialVersionUID = 1L;
}