package com.wzf.helper;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.wzf.context.request.RequestContext;

/**
 * @author Administrator
 * 视图处理器策略
 */
public class ViewFactory {

	@SuppressWarnings("rawtypes")
	private Map viewMap = new HashMap();

	public static ViewFactory getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getViewTemplate(RequestContext requestContext,
			String logicViewName) {

		String viewHandle;

		Locale locale = requestContext.getUserLocal();
		String userAgent = requestContext.getUserAgent();

		// 通过视图映射确定ViewHandle（视图句柄）
		viewHandle = getViewHandle(logicViewName, userAgent, locale);

		return viewHandle;
	}

	private String getViewHandle(String logicViewName, String userAgent,
			Locale locale) {

		// 根据逻辑视图名称、用户客户端类型、用户区域设置等确定视图模板
		ViewMapkey viewKey = new ViewMapkey(logicViewName, userAgent, locale);
		String viewName = (String) viewMap.get(viewKey);

		return viewName;
	}

}
