package com.himalaya.aop.advice;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import com.himalaya.BaseTestCase;
import com.himalaya.aop.service.IService;
import com.himalaya.aop.service.Monitorable;
import com.himalaya.aop.service.impl.ServiceImpl;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年5月2日 下午5:23:35 Description
 */
public class AdviceTest extends BaseTestCase {

	@Test
	public void testBeforeAdvice() {

		IService service = new ServiceImpl();
		BeforeAdvice advice = new BeforeAdvice();
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(service);
		factory.addAdvice(advice);
		IService proxy = (IService) factory.getProxy();
		proxy.service("fred");
	}

	/**
	 * test before advice
	 */
	@Test
	public void testAfterAdvice() {

		IService proxy = (IService) ctx.getBean("proxyService");
		proxy.service("fred");
	}

	/**
	 * test before advice
	 */
	@Test
	public void testAroundAdvice() {

		IService proxy = (IService) ctx.getBean("proxyService1");
		proxy.service("fred");
	}

	/**
	 * test before advice NullPointerException will be threw
	 */
	@Test
	public void testAroundAdviceNull() {

		IService proxy = (IService) ctx.getBean("proxyService1");
		proxy.service();
	}

	/**
	 * test before advice NullPointerException will be threw
	 */
	@Test
	public void testTransactionManagerAdvice() {

		IService proxy = (IService) ctx.getBean("proxyService2");
		try {
			proxy.save("fred");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/**
	 * test before advice NullPointerException will be threw
	 */
	@Test
	public void testIntroductionInterceptorAdvice() {

		IService proxy = (IService) ctx.getBean("proxyService3");
		proxy.service("fred");
		System.out.println("======================================");
		Monitorable monitor = (Monitorable)proxy;
		monitor.setMonitorAdvice(true);
		proxy.service("fred");
	}
}