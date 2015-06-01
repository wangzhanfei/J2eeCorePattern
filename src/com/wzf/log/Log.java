package com.wzf.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Administrator
 * 日志操作
 */
public class Log {

	public static Log log;

	private static String filePath;

	public static void setFilePath(String filePath) {
		Log.filePath = filePath;
	}

	private Log() {
	}

	public static Log getInstance() {
		if (log == null) {
			log = new Log();
		}
		return log;
	}

	private static Logger getLogger(Class<?> cls) {

		Logger logger = Logger.getLogger(cls.getName());
		PropertyConfigurator.configure(filePath);

		return logger;
	}

	/**
	 * 调试
	 */
	public static void debug(Class<?> cls, String msg) {
		Logger logger = getLogger(cls);
		logger.debug(msg);
	}

	/**
	 * 消息
	 */
	public static void info(Class<?> cls, String msg) {
		Logger logger = getLogger(cls);
		logger.info(cls.getName() + "   " + msg);
	}

	/**
	 * 警告
	 */
	public static void warn(Class<?> cls, String msg) {
		Logger logger = getLogger(cls);
		logger.warn(cls.getName() + "   " + msg);
	}

	/**
	 * 错误
	 */
	public static void error(Class<?> cls, String msg) {
		Logger logger = getLogger(cls);
		logger.error(cls.getName() + "   " + msg);
	}

	/**
	 * 致命错误
	 */
	public static void fatal(Class<?> cls, String msg) {
		Logger logger = getLogger(cls);
		logger.fatal(cls.getName() + "   " + msg);
	}
}
