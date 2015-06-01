package com.wzf.controller.application;

import java.util.Map;

import com.wzf.command.Command;
import com.wzf.command.CommandFactory;
import com.wzf.command.CommandMap;
import com.wzf.command.CommandMapper;
import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;

public class ApplicationController {

	private RequestContext requestContext;

	private CommandMapper commandMapper;

	//
	// public ApplicationController(RequestContext requestContext) {
	// this.requestContext = requestContext;
	//
	// }

	public ResponseContext handleRequest(RequestContext requestContext) {

		handleRequest2(requestContext);

		return null;
	}

	/**
	 * context对象策略，POJO
	 * @param requestContext
	 * @return
	 */
	private ResponseContext handleRequest2(RequestContext requestContext) {
		// 验证请求参数
		requestContext.validate();

		String commondName = requestContext.getCommandName();
		Command command = CommandFactory.createCommand(commondName);

		ResponseContext responseContext=command.execute(requestContext);
		
		//确定视图名称
		CommandMap commandMap=CommandFactory.getCommandMap(commondName);
		
		String viewName=commandMap.getViewName();
		
		responseContext.setLogicViewName(viewName);
		
		return responseContext;
	}

	public void handleReponse(RequestContext requestContext,
			ResponseContext responseContext) {

	}

	public ResponseContext handleRequest(Map<String, Object> requestContextMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleReponse(Map<String, Object> requestContextMap,
			ResponseContext responseContext) {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		commandMapper = CommandMapper.getInstance();
	}

}
