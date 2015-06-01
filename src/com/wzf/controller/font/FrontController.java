package com.wzf.controller.font;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.command.Command;
import com.wzf.context.request.RequestContext;
import com.wzf.context.response.ResponseContext;
import com.wzf.controller.application.ApplicationController;
import com.wzf.helper.Dispatcher;
import com.wzf.helper.RequestHelper;

public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public FrontController() {
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

		processRequest(request, response);
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

		processRequest(request, response);

	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String page = null;

		RequestContext requestContext = new RequestContext(request, response);

		ApplicationController applicationController = new ApplicationController();

		ResponseContext responseContext = applicationController
				.handleRequest(requestContext);

		applicationController.handleReponse(requestContext, responseContext);

		// dispatch(request, response, page);

	}

	/** 
	 * 命令加控制器策略+多路资源映射策略
	 * 利用url的部分信息结合以上策略:www.xxx.com/controller_action
	 * (controller控制下的action方法，
	 * 或者自定义正则表达式:controller_act*，controller下以act开头的方法)
	 */

	/** 
	 * 命令加控制器策略
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequestCommand(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String page = null;

		RequestHelper helper = new RequestHelper(request);

		Command command = helper.getCommand();
		page = command.execute(request, response);

		dispatch(request, response, page);

	}

	private void dispatch(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public String getServletInfo() {
		return super.getServletInfo();
	}
}
