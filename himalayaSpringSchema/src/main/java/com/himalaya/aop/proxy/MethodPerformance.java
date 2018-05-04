package com.himalaya.aop.proxy;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月3日 上午10:27:36
* Description
*/
public class MethodPerformance {

	private long begin;
	private long end;
	private String serviceMethod;
	
	public MethodPerformance(String methodName){
		this.serviceMethod = methodName;
		this.begin = System.currentTimeMillis();
	}
	
	public void printPerformance(){
		
		end = System.currentTimeMillis();
		System.out.println(serviceMethod + " cost " + (end - begin) + " millisecond.");
	}
}