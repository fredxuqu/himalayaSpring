package com.himalaya.entity;

import java.io.Serializable;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月11日 下午4:14:50
* Description
*/
public class UserDO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return id + " " + name;
	}
}