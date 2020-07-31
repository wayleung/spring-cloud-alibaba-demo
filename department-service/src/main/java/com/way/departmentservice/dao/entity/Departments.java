package com.way.departmentservice.dao.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

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