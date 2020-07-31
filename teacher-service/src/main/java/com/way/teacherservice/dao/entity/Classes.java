package com.way.teacherservice.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-02
 */
@Data
@Table(name="classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
}
