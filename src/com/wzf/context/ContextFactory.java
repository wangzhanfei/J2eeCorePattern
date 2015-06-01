package com.wzf.context;

import java.util.HashMap;

import com.wzf.context.request.RequestContext;

public class ContextFactory {

	public final static String REQUEST_CONTEXT = "request_context";

	private static HashMap<String, String> stringMap = new HashMap<String, String>();

	static {
		stringMap.put(REQUEST_CONTEXT, RequestContext.class.getName());
	}

	public static Context createContext() {

		return null;
	}

	private ContextFactory() {
	}
}
