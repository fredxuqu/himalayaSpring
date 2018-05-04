package com.himalaya.aop.service.impl;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.himalaya.BaseTestCase;
import com.himalaya.aop.proxy.PerformanceHandler;
import com.himalaya.aop.service.IProxyService;
import com.himalaya.aop.service.IService;
import com.himalaya.aop.service.impl.ProxyServiceImpl;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:23:35
* Description
*/
public class ProxyServiceImplTest extends BaseTestCase {
	
	@Test
	public void testProxy(){
		
		IProxyService target = new ProxyServiceImpl();
		PerformanceHandler performanceHandler = new PerformanceHandler(target);
		IProxyService proxyService = (IProxyService)Proxy.newProxyInstance(target.getClass().getClassLoader(),
															target.getClass().getInterfaces(),
															performanceHandler);
		proxyService.service();
	}	
}