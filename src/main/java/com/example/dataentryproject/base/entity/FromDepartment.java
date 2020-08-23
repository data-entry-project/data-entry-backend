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
@Table(name = "from_department")
public class FromDepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int deptId;

	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "dept_head")
	private String deptHead;

	@Column(name = "dept_number")
	private String deptNumber;

	@Column(name = "dept_address")
	private String deptAddress;

	@Column(name = "date_created")
	private Date dateCreated;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fromDepartment", cascade = CascadeType.ALL)
	private Set<ReportData> reportDatas;
}
