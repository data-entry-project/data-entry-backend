package com.example.dataentryproject.base.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.dataentryproject.base.dao.DeptBranchRepository;
import com.example.dataentryproject.base.dao.FromDepartmentRepository;
import com.example.dataentryproject.base.dao.ReportDataRepository;
import com.example.dataentryproject.base.dto.DeptBranchDto;
import com.example.dataentryproject.base.dto.FromDepartmentDto;
import com.example.dataentryproject.base.dto.ReportDataDto;
import com.example.dataentryproject.base.dto.SearchDto;
import com.example.dataentryproject.base.entity.DeptBranch;
import com.example.dataentryproject.base.entity.FromDepartment;
import com.example.dataentryproject.base.entity.ReportData;
import com.example.dataentryproject.base.exception.DataException;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private ReportDataRepository reportDataRepository;

	@Autowired
	private FromDepartmentRepository fromDepartmentRepository;

	@Autowired
	private DeptBranchRepository deptBranchRepository;

	@Override
	public void saveReport(ReportDataDto reportDataDto) {
		ReportData reportData = new ReportData().setDate_created(new Date());
		if (reportDataDto.getDeptBranchDto().getBranchId() != null) {
			reportData
					.setDeptBranch(deptBranchRepository.findById(reportDataDto.getDeptBranchDto().getBranchId()).get());

		} else {
			if (deptBranchRepository.findByName(reportDataDto.getDeptBranchDto().getBranchName()) != null) {
				throw new DataException(HttpStatus.BAD_REQUEST, "Dept Branch Already Exist with this name.");

			}
			DeptBranch deptBranch = new DeptBranch().setBranchName(reportDataDto.getDeptBranchDto().getBranchName())
					.setBranchNumber(reportDataDto.getDeptBranchDto().getBranchNumber())
					.setBranchHead(reportDataDto.getDeptBranchDto().getBranchHead()).setDateCreated(new Date());
			deptBranchRepository.save(deptBranch);
			reportData.setDeptBranch(deptBranch);
		}
		if (reportDataDto.getFromDepartmentDto().getDeptId() != null) {
			reportData.setFromDepartment(
					fromDepartmentRepository.findById(reportDataDto.getFromDepartmentDto().getDeptId()).get());
		} else {

			if (fromDepartmentRepository.findByName(reportDataDto.getFromDepartmentDto().getDeptName()) != null) {
				throw new DataException(HttpStatus.BAD_REQUEST, "Department Already Exist with this name.");

			}
			FromDepartment fromDepartment = new FromDepartment().setDateCreated(new Date())
					.setDeptName(reportDataDto.getFromDepartmentDto().getDeptName())
					.setDeptHead(reportDataDto.getFromDepartmentDto().getDeptHead())
					.setDeptNumber(reportDataDto.getFromDepartmentDto().getDeptNumber())
					.setDeptAddress(reportDataDto.getFromDepartmentDto().getDeptAddress());
			fromDepartmentRepository.save(fromDepartment);
			reportData.setFromDepartment(fromDepartment);
		}
		reportData.setReport(reportDataDto.getReport());
		if (reportDataDto.getStatus() != null) {
			reportData.setStatus(reportDataDto.getStatus());
		}
		reportDataRepository.save(reportData);
	}

	@Override
	public void editReport(ReportDataDto reportDataDto) {
		Optional<ReportData> reportDataOptional = reportDataRepository.findById(reportDataDto.getReport_id());
		if (reportDataOptional == null) {
			throw new DataException(HttpStatus.BAD_REQUEST, "Report Does Not Exist");
		}
		ReportData reportData = reportDataOptional.get();
		if (reportDataDto.getDeptBranchDto() != null) {
			if (reportDataDto.getDeptBranchDto().getBranchId() != null) {
				reportData.setDeptBranch(
						deptBranchRepository.findById(reportDataDto.getDeptBranchDto().getBranchId()).get());

			} else {
				DeptBranch deptBranch = new DeptBranch().setBranchName(reportDataDto.getDeptBranchDto().getBranchName())
						.setBranchNumber(reportDataDto.getDeptBranchDto().getBranchNumber())
						.setBranchHead(reportDataDto.getDeptBranchDto().getBranchHead()).setDateCreated(new Date());
				deptBranchRepository.save(deptBranch);
				reportData.setDeptBranch(deptBranch);
			}
		}
		if (reportDataDto.getFromDepartmentDto() != null) {
			if (reportDataDto.getFromDepartmentDto().getDeptId() != null) {
				reportData.setFromDepartment(
						fromDepartmentRepository.findById(reportDataDto.getFromDepartmentDto().getDeptId()).get());
			} else {
				FromDepartment fromDepartment = new FromDepartment().setDateCreated(new Date())
						.setDeptName(reportDataDto.getFromDepartmentDto().getDeptName())
						.setDeptHead(reportDataDto.getFromDepartmentDto().getDeptHead())
						.setDeptNumber(reportDataDto.getFromDepartmentDto().getDeptNumber())
						.setDeptAddress(reportDataDto.getFromDepartmentDto().getDeptAddress());
				fromDepartmentRepository.save(fromDepartment);
				reportData.setFromDepartment(fromDepartment);
			}
		}
		if (reportDataDto.getReport() != null) {
			reportData.setReport(reportDataDto.getReport());
		}
		if (reportDataDto.getStatus() != null) {
			reportData.setStatus(reportDataDto.getStatus());
		}
		reportDataRepository.save(reportData);

	}

	@Override
	public ReportDataDto searchReport(SearchDto searchDto) {
		ReportData reportData = reportDataRepository.findById(searchDto.getOffset()).get();
		System.out.println(reportData);
		ReportDataDto reportDataDto = new ReportDataDto();
		DeptBranch DeptBranch = reportData.getDeptBranch();
		;

		DeptBranchDto deptBranchDto = new DeptBranchDto();
		deptBranchDto.setBranchId(DeptBranch.getBranchId());
		deptBranchDto.setBranchHead(DeptBranch.getBranchHead());
		deptBranchDto.setBranchName(DeptBranch.getBranchName());
		deptBranchDto.setBranchNumber(DeptBranch.getBranchNumber());
		deptBranchDto.setDateCreated(DeptBranch.getDateCreated());
		reportDataDto.setDeptBranchDto(deptBranchDto);

		FromDepartmentDto fromDepartmentDto = new FromDepartmentDto();
		FromDepartment fromDepartment = reportData.getFromDepartment();
		fromDepartmentDto.setDateCreated(fromDepartment.getDateCreated());
		fromDepartmentDto.setDeptAddress(fromDepartment.getDeptAddress());
		fromDepartmentDto.setDeptHead(fromDepartment.getDeptHead());
		fromDepartmentDto.setDeptId(fromDepartment.getDeptId());
		fromDepartmentDto.setDeptName(fromDepartment.getDeptName());
		fromDepartmentDto.setDeptNumber(fromDepartment.getDeptNumber());
		reportDataDto.setFromDepartmentDto(fromDepartmentDto);
		reportDataDto.setDate_created(reportData.getDate_created());
		reportDataDto.setReport(reportData.getReport());
		reportDataDto.setReport_id(reportData.getReport_id());
		reportDataDto.setStatus(reportData.getStatus());
		// TODO Auto-generated method stub
		return reportDataDto;
	}

	@Override
	public List<FromDepartmentDto> getFromDepts() {
		List<FromDepartmentDto> fromDepartmentDtos = new ArrayList<FromDepartmentDto>();
		fromDepartmentRepository.findAll().forEach(fromDepartment->{
			FromDepartmentDto fromDepartmentDto = new FromDepartmentDto();
			fromDepartmentDto.setDateCreated(fromDepartment.getDateCreated());
			fromDepartmentDto.setDeptAddress(fromDepartment.getDeptAddress());
			fromDepartmentDto.setDeptHead(fromDepartment.getDeptHead());
			fromDepartmentDto.setDeptId(fromDepartment.getDeptId());
			fromDepartmentDto.setDeptName(fromDepartment.getDeptName());
			fromDepartmentDto.setDeptNumber(fromDepartment.getDeptNumber());
			fromDepartmentDtos.add(fromDepartmentDto);
			
		});
		
		// TODO Auto-generated method stub
		return fromDepartmentDtos;
	}

	@Override
	public List<DeptBranchDto> getDeptBranchs() {
		List<DeptBranchDto> deptBranchDtos = new ArrayList<DeptBranchDto>();
		deptBranchRepository.findAll().forEach(deptBranch->{
			DeptBranchDto deptBranchDto = new DeptBranchDto();
			deptBranchDto.setDateCreated(deptBranch.getDateCreated());
			deptBranchDto.setBranchHead(deptBranch.getBranchHead());
			deptBranchDto.setBranchId(deptBranch.getBranchId());
			deptBranchDto.setBranchName(deptBranch.getBranchName());
			deptBranchDto.setBranchNumber(deptBranch.getBranchNumber());
			deptBranchDtos.add(deptBranchDto);
			
		});
		
		// TODO Auto-generated method stub
		return deptBranchDtos;
	}
}