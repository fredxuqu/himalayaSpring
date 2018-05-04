package com.himalaya.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月3日 下午5:09:19
* Description
*/
public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		System.out.println("Before service.....");
	}
}
