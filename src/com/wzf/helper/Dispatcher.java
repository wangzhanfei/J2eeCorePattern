package com.wzf.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {

	HttpServletRequest request;

	HttpServletResponse response;

	public Dispatcher(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
}
