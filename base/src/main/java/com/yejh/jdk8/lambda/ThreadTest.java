package com.yejh.jdk8.lambda;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("Hello world !");  
		    }  
		}).start();  
		
		new Thread(() -> System.out.println("Hello world !")).start();  
	}

}
