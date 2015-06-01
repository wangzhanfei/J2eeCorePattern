package com.wzf.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class TemplateFilter implements Filter {

	private FilterConfig filterConfig;

	/**
	 * 前置处理
	 * @param request
	 * @param response
	 */
	public abstract void doPreProcessing(ServletRequest request,
			ServletResponse response);

	/**
	 * 后置处理
	 * @param request
	 * @param response
	 */
	public abstract void doPostProcessing(ServletRequest request,
			ServletResponse response);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		doPreProcessing(request, response);

		chain.doFilter(request, response);

		doPostProcessing(request, response);
	}

	@Override
	public void destroy() {

	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

}
