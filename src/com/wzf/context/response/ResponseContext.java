package com.wzf.context.response;

import com.sun.xml.internal.ws.client.RequestContext;

public class ResponseContext {

	private RequestContext requestContext;

	public ResponseContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public void setLogicViewName(String viewName) {

	}
}
