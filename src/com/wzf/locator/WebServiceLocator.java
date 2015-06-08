package com.wzf.locator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

public class WebServiceLocator {


	private InitialContext context;

	private Map cache;

	private static WebServiceLocator _serLocator;

	static {
		_serLocator = new WebServiceLocator();

	}

	private WebServiceLocator() {
		cache = Collections.synchronizedMap(new HashMap());
	}

	
}
