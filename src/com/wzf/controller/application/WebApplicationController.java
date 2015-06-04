package com.wzf.controller.application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.command.Command;
import com.wzf.command.CommandFactory;
import com.wzf.command.CommandProcessor;
import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;
import com.wzf.controller.interfaces.AppController;
import com.wzf.helper.ViewFactory;

public class WebApplicationController implements AppController {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseContext handleRequest(RequestContext requestContext) {
		// TODO Auto-generated method stub

		ResponseContext responseContext = null;

		// 确定命令名称
		String commandName = requestContext.getCommandName();

		// 获取命令
		Command command = CommandFactory.createCommand(commandName);

		// 用CommandProcessor处理命令
		CommandProcessor commandProcessor = new CommandProcessor();
		responseContext = commandProcessor.invoke(command, requestContext);

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wzf.controller.interfaces.AppController#handleResponse(com.wzf.context
	 * .request.RequestContext, com.wzf.context.response.ResponseContext)
	 * 视图处理器策略
	 */
	@Override
	public void handleResponse(RequestContext requestContext,
			ResponseContext responseContext) {
		ViewFactory viewFactory = ViewFactory.getInstance();

		// 根据逻辑视图名称、用户客户端类型、用户的区域设置等确定视图模板
		String viewTemplate = viewFactory.getViewTemplate(requestContext,
				responseContext.getLogicViewName());

		// 分派到视图处理机
		dispatch(requestContext.getRequest(), responseContext.getResponse(),
				viewTemplate);
	}

	private void dispatch(HttpServletRequest request,
			HttpServletResponse response, String viewTemplate) {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher(viewTemplate);
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub

	}

}
