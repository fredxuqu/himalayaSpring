package com.himalaya.aop.service.impl;

import java.sql.SQLException;

import com.himalaya.aop.proxy.PerformanceMonitor;
import com.himalaya.aop.service.IRefService;
import com.himalaya.aop.service.IService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:22:03
* Description
*/
public class ServiceImpl implements IService {

	IRefService refService;

	public IRefService getRefService() {
		return refService;
	}

	public void setRefService(IRefService refService) {
		this.refService = refService;
	}

	@Override
	public void service() {
		PerformanceMonitor.start(this.getClass().getName() + " service ");		
		System.out.println("service called...");
		float sum = 100000000.0009092f * 31201002020.232f;
		System.out.println(sum);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PerformanceMonitor.end();
	}
	
	@Override
	public void service(String name){
		System.out.println("service " + name);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void save(String name) throws Exception {
		System.out.println("saving ... " + name);
		throw new SQLException("Unique Constraints, key conflict!");
	}
	
	@Override
	public void update(String name) {
		System.out.println("updating ... " + name);
	}
}