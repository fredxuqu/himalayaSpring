package com.himalaya.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import com.himalaya.aop.proxy.PerformanceMonitor;
import com.himalaya.aop.service.Monitorable;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月4日 上午10:42:13
* Description
*/
public class IntroductionInterceptor extends DelegatingIntroductionInterceptor 
	implements Monitorable {

	private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<Boolean>(); 
	
	@Override
	public void setMonitorAdvice(boolean active) {
		monitorStatusMap.set(active);
	}
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		if(monitorStatusMap.get()!=null && monitorStatusMap.get()){
			PerformanceMonitor.start(mi.getClass().getName() + "." + mi.getMethod().getName());
			obj = super.invoke(mi);
			PerformanceMonitor.end();
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
}
