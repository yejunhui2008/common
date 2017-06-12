package com.yejh.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		//		for (int i = 0; i < 100; i++) {
		Future<?> future = executorService.submit(new Thread1(0));
		//		}
		try {
			future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread1 implements Runnable {
	int i = 0;

	public Thread1(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a = null;
		if (i == 2 && a.equals("")) {

		}
		System.out.println(Thread.currentThread().getName());
	}
}