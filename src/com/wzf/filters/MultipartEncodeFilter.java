package com.wzf.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MultipartEncodeFilter extends BaseEncodeFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("------------------MultipartEncodeFilter------------------");
		
		
		String contentType = request.getContentType();
		
		if(contentType.startsWith("multipart/form-data")){
			
			String uploadFolder=getFilterConfig().getInitParameter("uploadFolder");
			if(uploadFolder==null){
				uploadFolder=".";
			}
		}
		
		
		
		super.doFilter(request, response, chain);
	}
}
