package com.dealretail.common;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class ContextBean implements ServletContextAware {
	
	@Override
	public void setServletContext(ServletContext ctx) {
		ctx.setAttribute("appData", appData);
	}

	public ApplicationData getAppData() {
		return appData;
	}
	
	@Autowired
	private ApplicationData appData;
}
