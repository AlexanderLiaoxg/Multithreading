package com.cbry.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 廖兴广
它只是 ScheduledThreadPool 的一个特例，内部只有一个线程，如源码所示：

new ScheduledThreadPoolExecutor(1)
 */
public class SingleThreadScheduledExecutor {
	public static void main(String[] args) {
		
		ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadScheduledExecutor.scheduleAtFixedRate(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index);
				}
			},1,3, TimeUnit.SECONDS);
		}
	}
}
