package com.himalaya.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月3日 下午3:22:17
* Description
*/
public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class<?> clazz){		
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		PerformanceMonitor.start(obj.getClass().getName() +"." + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	} 
}