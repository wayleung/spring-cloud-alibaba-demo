package com.way.employeeservice.dao.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@Data
public class Employees {
    @Id
    private Integer empNo;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private Object gender;

    private Date hireDate;

}