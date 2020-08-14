package com.way.employeeservice.service.param;

import com.way.employeeservice.param.PageParam;
import lombok.Data;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@Data
public class DepartmentByIdParam extends PageParam {
    private String deptNo;
}
