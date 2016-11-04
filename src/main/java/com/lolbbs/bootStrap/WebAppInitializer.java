package com.lolbbs.bootStrap;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.lolbbs.filter.LoLCommonsRequestLoggingFilter;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Application.class);
		ctx.setServletContext(servletContext);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServlet);
		dynamic.setAsyncSupported(true);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);

		LoLCommonsRequestLoggingFilter filter = new LoLCommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludeClientInfo(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(8064);
		FilterRegistration.Dynamic requestFilter = servletContext.addFilter("requestFilter", filter);
		requestFilter.setAsyncSupported(true);
		requestFilter.addMappingForUrlPatterns(null, false, "/*");

		FilterRegistration.Dynamic charEncodingfilterReg = servletContext.addFilter("encodingFilter",
				new CharacterEncodingFilter());
		charEncodingfilterReg.setAsyncSupported(true);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");
	}
	
}
