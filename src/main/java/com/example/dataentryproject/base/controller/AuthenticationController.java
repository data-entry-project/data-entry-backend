package com.example.dataentryproject.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataentryproject.base.dto.Response;
import com.example.dataentryproject.base.dto.UserDetailDto;
import com.example.dataentryproject.base.service.UserService;
import com.example.dataentryproject.base.util.Messages;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {
	
	  @Autowired
	  private Messages messages;
	  
	  @Autowired
	  private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response login(@RequestBody(required = true) final UserDetailDto authenticationDetail) {
		// Authenticate the User.
		UserDetailDto authDetail = userService.authenticate(authenticationDetail);
		// Generate New Token
		return new Response(HttpStatus.OK.value(), messages.get("AUTHENTICATION_SUCCESS"), authDetail);
	}
	
	  @RequestMapping(value = "/logout", method = RequestMethod.DELETE,
		      produces = MediaType.APPLICATION_JSON_VALUE)
		  public Response logout(@RequestHeader("Authorization") String token) {
		    userService.logout(token);
		    return new Response(HttpStatus.OK.value(), messages.get("LOGOUT_SUCCESS"), null);
		  }

}
