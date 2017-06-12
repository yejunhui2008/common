package com.yejh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	private Object subject;

	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("start invoke");
		System.out.println("method:" + method);
		method.invoke(subject, args);
		System.out.println("end invoke");
		return null;
	}

}
