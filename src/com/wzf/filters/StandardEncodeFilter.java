package com.wzf.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StandardEncodeFilter extends BaseEncodeFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("------------------StandardEncodeFilter------------------");
		
		
		String contentType = request.getContentType();

		if (contentType == null
				|| contentType
						.equalsIgnoreCase("application/x-www-form-urlencoded")) {
			translateParamsToAttribute(request, response);
		}

		super.doFilter(request, response, chain);
	}

	private void translateParamsToAttribute(ServletRequest request,
			ServletResponse response) {
		Enumeration<String> paramsNames = request.getAttributeNames();

		while (paramsNames.hasMoreElements()) {

			String paramsName = paramsNames.nextElement();
			String values[] = request.getParameterValues(paramsName);

			if (values.length == 1) {
				request.setAttribute(paramsName, values[0]);
			} else {
				request.setAttribute(paramsName, values);
			}
		}

	}

}
