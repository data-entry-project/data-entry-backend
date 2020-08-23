package com.example.dataentryproject.base.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FromDepartmentDto {

	private Integer deptId;

	private String deptName;

	private String deptHead;

	private String deptNumber;

	private String deptAddress;

	private Date dateCreated;
}
