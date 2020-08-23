package com.example.dataentryproject.base.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptBranchDto {

	private Integer branchId;
	
	private String branchName;
	
	private String branchHead;
	
	private String branchNumber;
	
	private Date dateCreated;
	
}
