package com.wzf.cons;

import com.wzf.log.Log;
import com.wzf.system.SystemService;

public class CommonCons {

	public final static String logPropertyPath;

	public final static String FILE_SEPARATOR = SystemService
			.getFileSeparator();

	/**
	 * 命令参数，用于工厂方法的参数化
	 */
	public final static String COMMAND_OPTION = "command";

	static {
		String path = SystemService.getRoot();

		logPropertyPath = path + FILE_SEPARATOR + "config" + FILE_SEPARATOR
				+ "log" + FILE_SEPARATOR + "log4j.properties";

		Log.setFilePath(logPropertyPath);
	}

	public static void main(String[] args) {

		System.out.println(logPropertyPath);

		Log.debug(CommonCons.class, "------------");
	}
}
