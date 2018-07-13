package com.himalaya.repository;
/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:24:33
* Description
*/
public interface IAccountDao {
	
	public void add(int account, Double amount);
	
	public void deduct(int account, Double amount);
}
