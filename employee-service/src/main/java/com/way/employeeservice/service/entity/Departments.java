package com.way.employeeservice.service.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * departments
 * @author 
 */
@Data
public class Departments {
    @Id
    private String deptNo;

    private String deptName;
}