package com.example.helloworld.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.helloworld.datasourece.DynamicDataSourceContextHolder;

//@WebFilter(filterName = "DynamicDataSourceFilter", urlPatterns = { "/hello","/sso","/mybatis" })
public class DynamicDataSourceFilter implements Filter {

	private final static Logger logger = LoggerFactory.getLogger(DynamicDataSourceFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String dbName = httpServletRequest.getHeader("tenant-key");
        logger.info("DynamicDataSourceFilter:" + (dbName == null ? "default" : dbName));
        if (dbName != null) {
        	DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO
	}

}
