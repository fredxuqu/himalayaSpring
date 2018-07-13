package com.himalaya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.himalaya.entity.UserDO;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月11日 下午4:07:03
* Description
*/
@Service("serviceImpl")
public class ServiceImpl {

	@Autowired
	@Qualifier("daoImpl")
	DaoImpl dao;
	
	public UserDO get(int id){
		System.out.println("ServiceImpl get user by id " + id);
		return dao.get(id);
	}
	
	public String get(String id){
		System.out.println("ServiceImpl get user by id " + id);
		return dao.get(id);
	}
	
	public String get(UserDO user){
		System.out.println("ServiceImpl get user by id " + user.getId());
		return dao.get(user).toString();
	}
}