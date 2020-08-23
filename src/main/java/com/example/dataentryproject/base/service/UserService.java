package com.example.dataentryproject.base.service;

import com.example.dataentryproject.base.dto.UserDetailDto;

public interface UserService {

	UserDetailDto authenticate(UserDetailDto authenticationDetail);

	void logout(String token);

}
