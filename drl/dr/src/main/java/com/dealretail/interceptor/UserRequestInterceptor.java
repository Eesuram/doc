package com.dealretail.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dealretail.common.Constants;
import com.dealretail.dto.User;
import com.dealretail.model.BaseBean;

public class UserRequestInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		HttpSession session = request.getSession(false);
		
		if (null != session && null != session.getAttribute(Constants.USER_INFO)) {
			User user = (User) session.getAttribute(Constants.USER_INFO);
			BaseBean bean = new BaseBean();
			bean.setUserId(user.getId());
			bean.setUserName(user.getFirstName());
			bean.setSignedIn(true);
			if (user.getPrivilegeId() == Constants.ROLE_ADMIN) {
				bean.setAdmin(true);
			}
			request.setAttribute("bean", bean);
		}

		return true;
	}

}
