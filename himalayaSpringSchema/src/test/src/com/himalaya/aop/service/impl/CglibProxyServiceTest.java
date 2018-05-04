package com.himalaya.aop.service.impl;

import org.junit.Test;

import com.himalaya.BaseTestCase;
import com.himalaya.aop.proxy.CglibProxy;
import com.himalaya.aop.service.impl.ProxyServiceImpl;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:23:35
* Description
*/
public class CglibProxyServiceTest extends BaseTestCase {
	
	@Test
	public void testProxy(){
		
		CglibProxy proxy = new CglibProxy();
		ProxyServiceImpl service = (ProxyServiceImpl)proxy.getProxy(ProxyServiceImpl.class);
		service.service();
	}
}