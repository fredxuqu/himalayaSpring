package com.himalaya.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月3日 上午10:43:44
* Description
*/
public class PerformanceHandler implements InvocationHandler {

	private Object target;
	
	public PerformanceHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.start(target.getClass().getName() + "." + method.getName());
		Object obj = method.invoke(target, args);
		PerformanceMonitor.end();
		return obj;
	}
}