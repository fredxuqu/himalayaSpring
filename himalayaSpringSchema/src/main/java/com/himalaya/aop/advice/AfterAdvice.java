package com.himalaya.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月3日 下午5:09:19
* Description
*/
public class AfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("after service....");
	}
}
