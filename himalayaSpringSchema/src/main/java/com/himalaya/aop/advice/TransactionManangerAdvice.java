package com.himalaya.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月4日 上午10:22:25
* Description
*/
public class TransactionManangerAdvice implements ThrowsAdvice {

	public void afterThrowing(Method method, Object[] args, Object target, 
			Exception ex) throws Throwable {
		System.out.println("Method : " + method.getName());
		System.out.println("Exception threw : " + ex.getMessage());
		System.out.println("Transaction rollbacked....");
	}
}