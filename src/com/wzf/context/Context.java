package com.wzf.context;

public abstract class Context {

	public abstract Object get(String name);

	public abstract void set(String name, Object object);

}
