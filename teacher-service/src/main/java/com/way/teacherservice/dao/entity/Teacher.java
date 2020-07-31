package com.way.teacherservice.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-01
 */
@Table(name="teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
}
