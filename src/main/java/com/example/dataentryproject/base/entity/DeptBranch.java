package com.example.dataentryproject.base.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "dept_branch")
public class DeptBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_id")
	private int branchId;
	
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "branch_head")
	private String branchHead;
	
	@Column(name = "branch_number")
	private String branchNumber;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deptBranch", cascade = CascadeType.ALL)
	private Set<ReportData> reportDatas;
}
