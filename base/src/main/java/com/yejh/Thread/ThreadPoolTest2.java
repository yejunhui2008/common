package com.yejh.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest2 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<?> future = executorService.submit(new Thread2());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread2 implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return "test";
	}
}