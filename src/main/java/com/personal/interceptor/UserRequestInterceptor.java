package com.personal.interceptor;

import com.personal.common.Constants;
import com.personal.entity.User;
import com.personal.model.BaseBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
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
