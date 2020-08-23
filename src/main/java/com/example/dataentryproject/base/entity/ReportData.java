package com.example.dataentryproject.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "report_data")
public class ReportData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int report_id;

	@Column(name = "report")
	private String report;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_dept_id")
	private FromDepartment fromDepartment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_branch_id")
	private DeptBranch deptBranch;

	@Column(name = "status")
	private String status;

	@Column(name = "date_created")
	private Date date_created;

	@Column(name = "report_no")
	private String report_no;

	@Column(name = "stamp_updated")
	private Date stamp_updated;

}
