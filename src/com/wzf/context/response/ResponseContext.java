package com.wzf.context.response;

import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.client.RequestContext;

public class ResponseContext {

	private RequestContext requestContext;

	public ResponseContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public void setLogicViewName(String viewName) {

	}

	public void setResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public String getLogicViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpServletResponse getResponse() {
		// TODO Auto-generated method stub
		return null;
	}
}
