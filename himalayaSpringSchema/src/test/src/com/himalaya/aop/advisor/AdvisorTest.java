package com.himalaya.aop.advisor;

import org.junit.Test;

import com.himalaya.BaseTestCase;
import com.himalaya.aop.service.IService;

/**
 * @author: xuqu
 * @E-mail: fredxuqu@163.com
 * @version 2018年5月2日 下午5:23:35 Description
 */
public class AdvisorTest extends BaseTestCase {

	/**
	 * test before advice
	 */
	@Test
	public void testStaticMethodAdvisor() {

		IService proxy = (IService) ctx.getBean("advisorService");
		proxy.service("fred");
		
		try {
			proxy.save("fred");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * test before advice
	 */
	@Test
	public void testRegExpAdvisor() {

		IService proxy = (IService) ctx.getBean("regExpService");
		proxy.service("fred");
		
		try {
			proxy.save("fred");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * test before advice
	 */
	@Test
	public void testDynamicPointcut() {

		IService proxy = (IService) ctx.getBean("dynamicService");
		System.out.println(proxy.hashCode());
		proxy.update("fred");
		proxy.update("anna");
		proxy.update("wendy");
		
		IService proxy1 = (IService) ctx.getBean("dynamicService");
		System.out.println(proxy1.hashCode());
		proxy1.update("fred");
		proxy1.update("anna");
		proxy1.update("wendy");
	}
}