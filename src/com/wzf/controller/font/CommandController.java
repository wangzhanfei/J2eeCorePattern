package com.wzf.controller.font;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.context.request.RequestContext;
import com.wzf.context.request.RequestContextFactory;
import com.wzf.context.response.ResponseContext;
import com.wzf.controller.ApplicationControllerFactory;
import com.wzf.controller.application.ApplicationController;
import com.wzf.controller.interfaces.AppController;

/**
 * @author Administrator
 * 应用控制器---命令处理器策略
 */
public class CommandController extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public CommandController() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {

		// 创建应用控制器请求
		ApplicationControllerFactory factory = ApplicationControllerFactory
				.getInstance();
		AppController appController = factory.getApplicationController(request);

		appController.init();

		// 创建ContextObject 封装与协议相关的请求状态
		RequestContextFactory requestContextFactory = RequestContextFactory
				.getInstance();

		RequestContext requestContext = requestContextFactory
				.createRequestContext(request);

		// 操作管理----定位并调用操作，处理特定请求
		ResponseContext responseContext = appController
				.handleRequest(requestContext);
		responseContext.setResponse(response);

		// 视图管理---导航并分派到合适的视图上
		appController.handleResponse(requestContext, responseContext);
		appController.destory();

	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
