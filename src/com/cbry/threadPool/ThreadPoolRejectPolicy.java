package com.cbry.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRejectPolicy {
public static void main(String[] args) {
	RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
	//ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,   new LinkedBlockingQueue<Runnable>(), handler);
	ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), handler);
	for (int i = 0; i < 100; i++) {
		final int index = i;
		tpe.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("第" + index + "个线程数   0" + Thread.currentThread().getName() + ":执行任务");
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("异常");
					e.printStackTrace();
				}
			}
		});
	}
}
}
