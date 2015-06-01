package com.wzf.controller.font;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzf.context.request.RequestContext;
import com.wzf.context.request.RequestContextFactory;
import com.wzf.context.response.ResponseContext;
import com.wzf.controller.application.ApplicationController;
import com.wzf.helper.Dispatcher;

public class ContextController extends HttpServlet {

	private ApplicationController applicationController;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public ContextController() {
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

	// ------------------------------------
	// context对象模式
	// ------------------------------------

	/** 
	 * 请求Context表策略
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequestContext(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> requestContextMap = new HashMap<String, Object>(
				request.getParameterMap());

		Dispatcher dispatcher = new Dispatcher(request, response);
		requestContextMap.put("dispatcher", dispatcher);

		ApplicationController applicationController = new ApplicationController();

		ResponseContext responseContext = applicationController
				.handleRequest(requestContextMap);

		applicationController.handleReponse(requestContextMap, responseContext);

	}

	/** 
	 * 请求Context POJO策略
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void processRequestPOJO(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestContextFactory factory = RequestContextFactory.getInstance();

		RequestContext requestContext = factory.createRequestContext(request);

		// 处理清楚
		ResponseContext responseContext = applicationController
				.handleRequest(requestContext);

		// 视图管理---导航并分配到适合的视图
		Dispatcher dispatcher = new Dispatcher(request, response);
		requestContext.setDispatcher(dispatcher);
		applicationController.handleReponse(requestContext, responseContext);

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
		// TODO Auto-generated method stub
		super.init(config);

		applicationController = new ApplicationController();
		applicationController.initialize();
	}

}
