package com.way.studentservice.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-06-02
 */
@Table(name="classes")
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
}
