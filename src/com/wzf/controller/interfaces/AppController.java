package com.wzf.controller.interfaces;

import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;

public interface AppController {

	void init();

	ResponseContext handleRequest(RequestContext requestContext);

	void handleResponse(RequestContext requestContext,
			ResponseContext responseContext);

	void destory();


}
