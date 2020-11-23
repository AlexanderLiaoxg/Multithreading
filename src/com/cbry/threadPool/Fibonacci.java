package com.cbry.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 廖兴广
 我们看到它首先继承了 RecursiveTask，RecursiveTask 类是对ForkJoinTask 的一个简单的包装
 创建递归任务，也就是 f1 和 f2，然后我们用 fork() 方法分裂任务并分别执行，最后在 return 的时候，使用 join() 方法把结果汇总，这样就实现了任务的分裂和汇总。
 */
class Fibonacci extends RecursiveTask<Integer>{
	
	int num;
	
	public Fibonacci(int num) {
		 this.num = num;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if(num<=1){
			return num;
			}
			Fibonacci f1 = new Fibonacci(num-1);
			f1.fork();
			Fibonacci f2 =new Fibonacci(num -2);
			f2.fork();
			return f1.join() + f2.join();
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		    for (int i = 0; i < 10; i++) { 
		        ForkJoinTask task = forkJoinPool.submit(new Fibonacci(i));
		        System.out.println(task.get());
		    } 
	}
}
