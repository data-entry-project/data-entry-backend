package com.example.dataentryproject.base.dto;

import java.util.Date;

import lombok.Getter;

@Getter
public class SearchDto {
private Integer[] fromDepartmentIds;
private Integer[] deptBranchIds;
private Integer offset;
private Date fromDate;
private Date toDate;
private String searchText;
}
