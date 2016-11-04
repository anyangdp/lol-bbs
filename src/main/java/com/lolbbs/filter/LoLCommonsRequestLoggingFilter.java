package com.lolbbs.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
public class LoLCommonsRequestLoggingFilter extends CommonsRequestLoggingFilter {

	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		//MDC.put("identify", NOGenerator.generate(10));
		//log.debug("$$$ {} $$$", message);
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		MDC.remove("identify");
	}
}
