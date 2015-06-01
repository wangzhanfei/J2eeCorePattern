package com.wzf.system;

import java.io.File;

public class SystemService {

	/**
	 * 系统分隔符
	 * @return
	 */
	public static String getFileSeparator() {
		return File.separator;
	}
	
	/**
	 * 应用根目录
	 * @return
	 */
	public static String getRoot(){
		return System.getProperty("user.dir");
	}
}
