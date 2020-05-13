package com.dealretail.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dealretail.common.Constants;
import com.dealretail.helper.CookieHelper;

public class FilterHandlerInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		Map<String, String> cookieMap = updateCookies(request, response);
		StringBuilder filterCriteria = new StringBuilder();
		HttpSession session = request.getSession(false);
		boolean signedIn = false;
		
		if (null != session
				&& null != session.getAttribute(Constants.USER_INFO)) {
			signedIn = true;
		}

		if (MapUtils.isEmpty(cookieMap)) {
			if (signedIn) {
				request.setAttribute("searchCriteria", " ORDER BY SAVINGS DESC");
			} else {
				request.setAttribute("searchCriteria", " WHERE SAVINGS < 40 ORDER BY SAVINGS DESC");
			}
			return true;
		} 
		
		// Add Category ID to Criteria
		if (StringUtils.isNotEmpty(cookieMap.get("categoryId"))) {
			filterCriteria.append("CAT_ID = '");
			filterCriteria.append(cookieMap.get("categoryId"));
			filterCriteria.append("'");
		}

		// Add Product Name to Criteria
		if (StringUtils.isNotEmpty(cookieMap.get("searchKey"))) {
			if (filterCriteria.length() > 0) {
				filterCriteria.append(" AND ");
			}
			filterCriteria.append("PRODUCT_NAME LIKE '%");
			filterCriteria.append(cookieMap.get("searchKey"));
			filterCriteria.append("%'");
		}

		// Add Price Range to Price Range
		if (StringUtils.isNotEmpty(cookieMap.get("priceRange"))) {
			String[] price = cookieMap.get("priceRange").split("-");

			if (filterCriteria.length() > 0) {
				filterCriteria.append(" AND ");
			}

			if (price[1].equalsIgnoreCase("above")) {
				filterCriteria.append("SALE_PRICE >= ");
				filterCriteria.append(Float.parseFloat(price[0]));
			} else {
				filterCriteria.append("SALE_PRICE BETWEEN ");
				filterCriteria.append(Float.parseFloat(price[0]));
				filterCriteria.append(" AND ");
				filterCriteria.append(Float.parseFloat(price[1]));
			}

		}

		// Add Savings to Price Range
		if (signedIn) {
			if (StringUtils.isNotEmpty(cookieMap.get("savings"))) {
				if (filterCriteria.length() > 0) {
					filterCriteria.append(" AND ");
				}

				filterCriteria.append("SAVINGS >= ");
				filterCriteria.append(Float.parseFloat(cookieMap.get("savings")));
			}
		} else {
			if (filterCriteria.length() > 0) {
				filterCriteria.append(" AND ");
			}

			filterCriteria.append("SAVINGS < 40");
		}

		if (filterCriteria.length() > 0) {
			filterCriteria.insert(0, " WHERE ");
		}

		if (StringUtils.isNotEmpty(cookieMap.get("sortBy"))) {
			if ("price".equalsIgnoreCase(cookieMap.get("sortBy"))) {
				filterCriteria.append(" ORDER BY SALE_PRICE");
			} else if ("savings".equalsIgnoreCase(cookieMap.get("sortBy"))) {
				filterCriteria.append(" ORDER BY SAVINGS DESC");
			}
		} else {
			filterCriteria.append(" ORDER BY SAVINGS DESC");
		}

		if (filterCriteria.length() > 0) {
			request.setAttribute("searchCriteria", filterCriteria.toString());
			request.setAttribute("cookieMap", cookieMap);
		}

		return true;
	}

	private Map<String, String> updateCookies(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> cookieMap = cookieHelper.readAllCookies(request);

		if (null == cookieMap) {
			cookieMap = new HashMap<String, String>();
		}

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = parameterNames.nextElement();
			String parameterValue = request.getParameter(parameterName);

			if ("removeCookie".equals(parameterName)) {
				cookieMap.remove(parameterValue);
				cookieHelper.removeCookie(request, response, parameterValue);
				cookieHelper.removeCookie(request, response, "removeCookie");
			}
			cookieMap.put(parameterName, parameterValue);
			cookieHelper.writeCookie(response, parameterName, parameterValue);
		}

		return cookieMap;
	}

	@Autowired
	private CookieHelper cookieHelper;
}
