package com.wzf.command;

import java.util.HashMap;

public class CommandFactory {

	public final static String CONCREATE_COMMAND = "concreateCommand";

	private static HashMap<String, String> stringMap = new HashMap<String, String>();

	static {
		stringMap.put(CONCREATE_COMMAND, ConcreateCommand.class.getName());
	}

	/**
	 * 根据参数实例化一个命令对象
	 * @param params
	 * @return  参数无效或者命令对象不存在则返回null
	 */
	public static Command createCommand(String params) {

		String clsPath = getClassPath(params);
		if (clsPath == null) {
			return null;
		}

		Object object = null;
		try {
			object = Class.forName(clsPath).newInstance();
		} catch (Exception e) {
			object = null;
			e.printStackTrace();
		}

		if (object instanceof Command) {
			return (Command) object;
		} else {
			return null;
		}
	}

	public static CommandMap getCommandMap(String name) {
		return null;
	}

	private static String getClassPath(String params) {

		return stringMap.get(params);
	}
}
