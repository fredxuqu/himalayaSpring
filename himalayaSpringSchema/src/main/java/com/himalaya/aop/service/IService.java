package com.himalaya.aop.service;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月2日 下午5:21:14
* Description
*/
public interface IService {

	public void service();
	public void service(String name);
	public void save(String name)throws Exception;
	public void update(String name);
}
