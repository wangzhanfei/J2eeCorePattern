package com.wzf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;

public abstract class Command {

	public abstract String execute(HttpServletRequest request,
			HttpServletResponse response);
	
	public abstract ResponseContext execute(RequestContext requestContext);

	@Override
	public String toString() {
		return super.toString();
	}
}
