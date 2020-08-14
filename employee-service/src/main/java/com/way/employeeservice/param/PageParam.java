package com.way.employeeservice.param;

import lombok.Data;

/**
 * @author wayleung 80551025
 * @description
 * @date 2020-07-31
 */
@Data
public class PageParam {
    private Integer pageIndex=1;
    private Integer pageSize=50;
}
