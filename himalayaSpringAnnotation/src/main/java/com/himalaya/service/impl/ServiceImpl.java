package com.himalaya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.himalaya.service.IRefService;
import com.himalaya.service.IService;

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

	public void service() {
		System.out.println("service called...");
		refService.refService();
	}
}
