package com.himalaya.service;

import org.springframework.stereotype.Repository;

import com.himalaya.entity.UserDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月11日 下午4:07:33
* Description
*/
@Repository("daoImpl")
public class DaoImpl {

	public UserDO get(int id){
		System.out.println("DAO get user by id " + id);
		UserDO user = new UserDO();
		user.setId(id);
		user.setName("fred");
		return user;
	}
	
	public UserDO get(UserDO user){
		System.out.println("DAO get user by user " + user.getId());
		return user;
	}
	
	public String get(String id){
		System.out.println("DAO get user by id " + id);
		return  id + " " + " hello.....";
	}
}