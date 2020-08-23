package com.example.dataentryproject.base.service;

import java.util.List;

import com.example.dataentryproject.base.dto.DeptBranchDto;
import com.example.dataentryproject.base.dto.FromDepartmentDto;
import com.example.dataentryproject.base.dto.ReportDataDto;
import com.example.dataentryproject.base.dto.SearchDto;

public interface DataService {

	void saveReport(ReportDataDto reportDataDto);

	void editReport(ReportDataDto reportDataDto);

	ReportDataDto searchReport(SearchDto searchDto);

	List<FromDepartmentDto> getFromDepts();

	List<DeptBranchDto> getDeptBranchs();

}
