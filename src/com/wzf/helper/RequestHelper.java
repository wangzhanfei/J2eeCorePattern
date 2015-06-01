package com.wzf.helper;

import javax.servlet.http.HttpServletRequest;

import com.wzf.command.Command;
import com.wzf.command.CommandFactory;
import com.wzf.cons.CommonCons;

public class RequestHelper {

	HttpServletRequest request;

	public RequestHelper(HttpServletRequest request) {
		this.request = request;
	}

	public Command getCommand() {

		return CommandFactory.createCommand(request
				.getParameter(CommonCons.COMMAND_OPTION));
	}
}
