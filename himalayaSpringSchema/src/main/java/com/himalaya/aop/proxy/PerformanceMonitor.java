package com.himalaya.aop.proxy;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:22:03
* Description
*/
public class PerformanceMonitor {

	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>(); 

	public static void start(String method) {
		System.out.println("monitor begin");
		performanceRecord.set(new MethodPerformance(method));
	}

	public static void end() {
		System.out.println("monitor end");
		performanceRecord.get().printPerformance();
	}
}