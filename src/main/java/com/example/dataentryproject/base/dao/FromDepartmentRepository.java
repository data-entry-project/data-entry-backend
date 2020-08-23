package com.example.dataentryproject.base.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.dataentryproject.base.entity.FromDepartment;

public interface FromDepartmentRepository extends CrudRepository<FromDepartment, Integer> 	{

	@Query("Select fd FROM FromDepartment fd WHERE fd.deptName = :deptName")
	FromDepartment findByName(@Param("deptName")String deptName);
	
}
