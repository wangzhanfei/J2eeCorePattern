package com.wzf.controller.application;

import java.io.Reader;
import java.io.StringReader;

import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;
import com.wzf.controller.interfaces.AppController;
import com.wzf.helper.TransformHelper;
import com.wzf.helper.ViewFactory;

public class TransformController implements AppController {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseContext handleRequest(RequestContext requestContext) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void handleResponse(RequestContext requestContext,
			ResponseContext responseContext) {
		// TODO Auto-generated method stub
		ViewFactory viewFactory = ViewFactory.getInstance();

		String stylesheet = viewFactory.getViewTemplate(requestContext,
				responseContext.getLogicViewName());

		TransformHelper transHelper = new TransformHelper();

		Reader xmlReader = new StringReader("");

		transHelper.transform(requestContext.getRequest(),
				responseContext.getResponse(), xmlReader);

	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub

	}

}
