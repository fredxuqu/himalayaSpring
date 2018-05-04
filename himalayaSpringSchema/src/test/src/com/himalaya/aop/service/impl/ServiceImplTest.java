package com.himalaya.aop.service.impl;

import org.junit.Test;

import com.himalaya.BaseTestCase;
import com.himalaya.aop.service.IProxyService;
import com.himalaya.aop.service.IService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:23:35
* Description
*/
public class ServiceImplTest extends BaseTestCase {

	@Test 
	public void testService(){
		IService service = (IService) ctx.getBean("service");
		service.service();
	}
}