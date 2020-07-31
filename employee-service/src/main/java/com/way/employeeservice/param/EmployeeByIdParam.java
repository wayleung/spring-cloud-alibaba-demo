package com.way.employeeservice.param;

import lombok.Data;

/**
 * @author liangliwei 80551025
 * @description
 * @date 2020-07-31
 */
@Data
public class EmployeeByIdParam extends PageParam{
    private Integer empNo;
}
