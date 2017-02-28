package com.yejh.proxy;

public class RealSubject implements Subject {

	public void say(String str) {
		System.out.println("hello:" + str);

	}

	public void action() {
		System.out.println("I can do it");
	}

}
