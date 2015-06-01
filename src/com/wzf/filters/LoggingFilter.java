package com.wzf.filters;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.wzf.log.Log;

public class LoggingFilter extends TemplateFilter {

	@Override
	public void doPreProcessing(ServletRequest request, ServletResponse response) {
		Log.debug(this.getClass(), "doPreProcessing");
	}

	@Override
	public void doPostProcessing(ServletRequest request,
			ServletResponse response) {
		Log.debug(this.getClass(), "doPostProcessing");
	}

}
