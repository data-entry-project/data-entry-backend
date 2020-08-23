package com.example.dataentryproject.base.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.dataentryproject.base.entity.DeptBranch;

public interface DeptBranchRepository extends CrudRepository<DeptBranch, Integer> {

	@Query("Select db FROM DeptBranch db WHERE db.branchName = :branchName")
	DeptBranch findByName(@Param("branchName") String branchName);

}
