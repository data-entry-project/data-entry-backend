package com.example.dataentryproject.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataentryproject.base.dto.DeptBranchDto;
import com.example.dataentryproject.base.dto.FromDepartmentDto;
import com.example.dataentryproject.base.dto.ReportDataDto;
import com.example.dataentryproject.base.dto.Response;
import com.example.dataentryproject.base.dto.SearchDto;
import com.example.dataentryproject.base.service.DataService;
import com.example.dataentryproject.base.util.Messages;

@RestController
@RequestMapping(value = "/reports")
public class ReportDataController {

	@Autowired
	private DataService dataService;
	
	@Autowired
	private Messages message;
	
	   @RequestMapping(value = "/add", method = RequestMethod.POST,
	       produces = MediaType.APPLICATION_JSON_VALUE)
	   public Response saveReport(
	       @Validated(ReportDataDto.New.class) @RequestBody ReportDataDto reportDataDto) {
		   dataService.saveReport(reportDataDto);
	     return new Response(HttpStatus.CREATED.value(), "Created", null);
	   }
	
	   @RequestMapping(value = "/update", method = RequestMethod.PATCH,
		       produces = MediaType.APPLICATION_JSON_VALUE)
		   public Response editReport(
		       @Validated(ReportDataDto.New.class) @RequestBody ReportDataDto reportDataDto) {
			   dataService.editReport(reportDataDto);
		     return new Response(HttpStatus.CREATED.value(), "Created", null);
		   }
		
	   @RequestMapping(value = "/getreports", method = RequestMethod.POST,
		       produces = MediaType.APPLICATION_JSON_VALUE)
		   public Response getReports(@RequestBody SearchDto searchDto) {
		   ReportDataDto reportDataDtos = dataService.searchReport(searchDto);
		     return new Response(HttpStatus.CREATED.value(), "GetRecords", reportDataDtos);
		   }
		
	   @RequestMapping(value = "/getfromdepts", method = RequestMethod.GET,
		       produces = MediaType.APPLICATION_JSON_VALUE)
		   public Response getFromDeptList() {
		   List<FromDepartmentDto> fromDepartmentDtos = dataService.getFromDepts();
		     return new Response(HttpStatus.CREATED.value(), "GetRecords", fromDepartmentDtos);
		   }
	   
	   @RequestMapping(value = "/getdeptbranches", method = RequestMethod.GET,
		       produces = MediaType.APPLICATION_JSON_VALUE)
		   public Response getDeptBranchList() {
		   List<DeptBranchDto> deptBranchDtos = dataService.getDeptBranchs();
		     return new Response(HttpStatus.CREATED.value(), "GetRecords", deptBranchDtos);
		   }
}
