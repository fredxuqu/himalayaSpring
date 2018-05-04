package com.himalaya.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月4日 上午10:09:21
* Description
*/
public class AroundInteceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		if(args!=null && args.length>0) {
			String clientName = (String)args[0];
			System.out.println("before service " + clientName);
		} else {
			System.out.println("before service ");
		}
		Object obj = invocation.proceed();
		System.out.println("after service");
		return obj;
	}
}