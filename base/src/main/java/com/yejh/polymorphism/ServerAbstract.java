package com.yejh.polymorphism;

public abstract class ServerAbstract {

	public void serve() {
		try {
			Class<?> classz = Class.forName(getClass().getName());
			ServerImpl server = (ServerImpl) classz.newInstance();
			server.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void sayHello();

}
