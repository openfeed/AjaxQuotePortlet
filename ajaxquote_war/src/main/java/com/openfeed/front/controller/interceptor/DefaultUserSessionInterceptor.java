package com.openfeed.front.controller.interceptor;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.openfeed.backend.vo.user.User;

public class DefaultUserSessionInterceptor extends BaseSessionInterceptor {

	private String defaultUsername;


	@Override
	protected boolean preHandle(PortletRequest request,
			PortletResponse response, Object handler) throws Exception {
		PortletSession session = request.getPortletSession(true);
		if (session.getAttribute(this.sessionUserParamName,
				PortletSession.APPLICATION_SCOPE) == null) {
			User user = userService.addUser(this.defaultUsername);
			session.setAttribute(this.sessionUserParamName, user,
					PortletSession.APPLICATION_SCOPE);
		}
		return true;
	}

	
	@Autowired
	public void setDefaultUsername(String defaultUsername) {
		this.defaultUsername = defaultUsername;
	}

	
}
