package com.example.dataentryproject.base.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReportDataDto {

	private Integer report_id;

	private String report;

	private FromDepartmentDto fromDepartmentDto;

	private DeptBranchDto deptBranchDto;

	private String status;

	private Date date_created;

	private String report_no;
	
	 public interface New {
	  }
}
