package com.way.employeeservice.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
public class Employees implements Serializable {
    private Integer empNo;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private Object gender;

    private Date hireDate;

    private static final long serialVersionUID = 1L;
}