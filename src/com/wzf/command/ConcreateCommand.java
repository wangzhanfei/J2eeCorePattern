package com.wzf.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;

public class ConcreateCommand extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		return null;
	}

	@Override
	public String toString() {

		return "ConcreateCommand";
	}

	@Override
	public ResponseContext execute(RequestContext requestContext) {
		return null;
	}

}
