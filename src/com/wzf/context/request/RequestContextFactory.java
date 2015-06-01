package com.wzf.context.request;

import javax.servlet.http.HttpServletRequest;

import com.wzf.command.CommandFactory;
import com.wzf.command.CommandMap;

public class RequestContextFactory {

	private static RequestContextFactory factory;

	public static RequestContextFactory getInstance() {

		if (factory == null) {
			factory = new RequestContextFactory();
		}
		return factory;
	}

	private RequestContextFactory() {

	}
	
	public RequestContext createRequestContext(HttpServletRequest request){
		
		
		RequestContext requestContext=null;
		
		String commandId=getCommandId(request);
		
		CommandMap map=CommandFactory.getCommandMap(commandId);
		
		return null;
	}
	private String getCommandId(HttpServletRequest request){
		return null;
		
	}
}
