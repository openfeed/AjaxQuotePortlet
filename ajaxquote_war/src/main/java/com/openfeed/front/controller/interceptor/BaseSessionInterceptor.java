package com.openfeed.front.controller.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

import com.openfeed.backend.sl.user.UserService;

public class BaseSessionInterceptor extends HandlerInterceptorAdapter {

	protected UserService userService;
	protected String sessionUserParamName;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setSessionUserParamName(String sessionUserParamName) {
		this.sessionUserParamName = sessionUserParamName;
	}

}
