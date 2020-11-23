package com.cbry.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

		// 延迟inde秒则会跟顺序输出
		for (int i = 0; i < 10; i++) {
			final int index = i;
			scheduledThreadPool.schedule(new Runnable() {
				public void run() {
					System.out.println("第" + index + "个，" + "delay 3 seconds");
				}
			}, 3, TimeUnit.SECONDS);
		}

		// 延迟1秒，每两秒执行一次
		for (int i = 0; i < 10; i++) {
			final int index = i;
			scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
				public void run() {
					System.out.println("第" +index + "个，delay 1 seconds, and excute every 3 seconds");
				}
			}, 1, 2, TimeUnit.SECONDS);
		}

	}
}
