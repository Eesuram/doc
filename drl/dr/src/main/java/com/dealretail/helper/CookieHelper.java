package com.dealretail.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;

@Component
public class CookieHelper {

	public String readCookie(HttpServletRequest request, String cookieName) {
	
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					return cookies[i].getValue();
				}
			}
		}
		
		return null;
	}
	
	public void writeCookie(HttpServletResponse response, String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}

	public Map<String, String> readAllCookies(HttpServletRequest request) {
		Map<String, String> cookieMap = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			cookieMap = new HashMap<String, String>();
			
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i].getValue());
			}
		}

		return cookieMap;
	}
	
	public void writeAllCookies(HttpServletRequest request, 
			HttpServletResponse response, Map<String, String> cookieMap) {
		if (MapUtils.isNotEmpty(cookieMap)) {
			Set<Map.Entry<String, String>> entrySet = cookieMap.entrySet();
			for (Map.Entry<String, String> entry : entrySet) {
				removeCookie(request, response, entry.getKey());
				Cookie cookie = new Cookie(entry.getKey(), entry.getValue());
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
			}
		}
	}
	
	public void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					cookies[i].setPath("/");
					cookies[i].setValue("");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}
	}

	public void removeAllCookies(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					cookies[i].setPath("/");
					cookies[i].setValue("");
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
	}
}
