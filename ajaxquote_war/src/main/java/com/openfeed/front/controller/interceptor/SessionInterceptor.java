package com.openfeed.front.controller.interceptor;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;

import com.openfeed.backend.vo.user.User;

public class SessionInterceptor extends BaseSessionInterceptor {


	@Override
	protected boolean preHandle(PortletRequest request,
			PortletResponse response, Object handler) throws Exception {
		PortletSession session = request.getPortletSession(true);
		if (session.getAttribute(this.sessionUserParamName,
				PortletSession.APPLICATION_SCOPE) == null) {
			String username = request.getRemoteUser();
			if (username == null) {
				return false;
			}
			User user = userService.addUser(username);
			session.setAttribute(this.sessionUserParamName, user,
					PortletSession.APPLICATION_SCOPE);
		}
		return true;
	}

}
