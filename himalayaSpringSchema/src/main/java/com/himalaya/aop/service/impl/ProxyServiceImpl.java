package com.himalaya.aop.service.impl;

import com.himalaya.aop.service.IProxyService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:22:03
* Description
*/
public class ProxyServiceImpl implements IProxyService {
		
	public void service() {	
		System.out.println("service called...");
		float sum = 100000000.0009092f * 31201002020.232f;
		System.out.println(sum);
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}