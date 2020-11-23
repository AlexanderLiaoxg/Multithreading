package com.cbry.threadPool;

import java.util.concurrent.*;

/**
 * @author 廖兴广
 *核心进程和最大进程数相等，且缓存队列无限制（LinkedBlockingQueue）
 */
public class FixedThreadPool {
		
	public static void main(String[] args) {
			        ExecutorService service = Executors.newFixedThreadPool(5);
			        for (int i = 0; i < 10000; i++) { 
			            service.execute(new Task());
			        } 
			    System.out.println(Thread.currentThread().getName());
	}
	
	static class Task implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread Name: " + Thread.currentThread().getName());
		}

	} 
}
