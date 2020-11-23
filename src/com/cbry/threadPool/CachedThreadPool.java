package com.cbry.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 廖兴广 CachedThreadPool：无界线程池，可以进行自动线程回收。
 * 实际最大可以达到 Integer.MAX_VALUE，为 2^31-1，
 */
public class CachedThreadPool {
	public static void main(String[] args) {

//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			 int index = 1;
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					System.out.println(index);
//				}
//			});
//			index++;
//		}
		
		int n =0;
		TestObj testObj = new TestObj(n);

		add(testObj);
		System.out.println("这是形参对象的n的自增两次1的结果：" + testObj.val);
		System.out.println("这是main函数里面的n：" + n);
	}
	
	public static void add(TestObj temp) {
		temp.val+=2;
	}
}
