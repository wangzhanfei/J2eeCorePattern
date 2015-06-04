package com.wzf.context.request;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.helper.Dispatcher;

public class RequestContext {

	HttpServletRequest request;

	HttpServletResponse response;

	public RequestContext(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void setAttribute(String name, Object object) {
		request.setAttribute(name, object);

	}

	public Object getAttribute(String name) {

		return request.getAttribute(name);
	}

	public void setDispatcher(Dispatcher dispatcher) {
		
	}

	public void validate() {
		// TODO Auto-generated method stub
		
	}

	public String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpServletRequest getRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public Locale getUserLocal() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserAgent() {
		// TODO Auto-generated method stub
		return null;
	}

}
