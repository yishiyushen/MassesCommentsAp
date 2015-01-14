package com.longhui.net;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolUtils {
	public ThreadPoolUtils() {
		// TODO Auto-generated constructor stub
	}
	/**并行线程数*/
	private static int CORE_POOL_SIZE = 3;
	/**线程池最大线程数*/
	private static int MAX_POOL_SIZE = 200;
	/***/
	private static int KEEP_ALIVE_TIME = 5000;
	
	private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(
			15);
	/**线程工厂方法*/
	private static ThreadFactory threadFactory = new ThreadFactory() {
		
		private final AtomicInteger ineger = new AtomicInteger(); //原子变量
		public Thread newThread(Runnable r) {
			return new Thread(r, "MyThreadPool thread:"+ineger.getAndIncrement());
		};
	};
	
	/***/
	private static RejectedExecutionHandler handler = new RejectedExecutionHandler() {
		public void rejectedExecution(Runnable r, java.util.concurrent.ThreadPoolExecutor executor) {
			
		};
	};
	
	private static ThreadPoolExecutor threadpool;//线程池
	
	static {
		threadpool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
				KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue, threadFactory,
				handler);
	}
	
	public static void execute(Runnable runnable) {
		threadpool.execute(runnable);
	}
}
