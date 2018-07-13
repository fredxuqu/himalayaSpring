package com.himalaya.demo3;

import java.util.List;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年7月13日 上午9:24:33
* Description
*/
public interface IAccountDao {
	
	public void add(String account, Double amount);
	
	public void deduct(String account, Double amount);
	
	public void addAccount(String account, Double amount);
	
	public List<String> listAllAccount();
}
