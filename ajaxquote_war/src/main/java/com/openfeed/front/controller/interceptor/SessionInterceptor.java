package com.openfeed.front.controller.interceptor;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

import com.openfeed.backend.sl.user.UserService;
import com.openfeed.backend.vo.user.User;
import com.openfeed.front.controller.portal.IFrontOpenfeedContants;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	private Long defaultUserId;
	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setDefaultUserId(Long defaultUserId) {
		this.defaultUserId = defaultUserId;
	}

	@Override
	protected boolean preHandle(PortletRequest request,
			PortletResponse response, Object handler) throws Exception {
		// super.preHandle(request, response, handler);

		PortletSession session = request.getPortletSession(true);
		if (session.getAttribute(IFrontOpenfeedContants.OPENFEED_USER,
				PortletSession.APPLICATION_SCOPE) == null) {
			String username = request.getRemoteUser();
			User user = null;
			if (username == null) {
				username = "of_public_user";
			}
			user = userService.addUser(username);
			session.setAttribute(IFrontOpenfeedContants.OPENFEED_USER, user,
					PortletSession.APPLICATION_SCOPE);
		}
		return true;
	}

}
