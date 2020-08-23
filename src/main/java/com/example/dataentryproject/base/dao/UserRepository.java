package com.example.dataentryproject.base.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dataentryproject.base.entity.UserDetail;

@Repository
public interface UserRepository extends CrudRepository<UserDetail, Integer> 	 {


	@Query("Select u from UserDetail u where u.userName = :userName")
	UserDetail findByEmailAndPassword(@Param("userName")String userName);

}
