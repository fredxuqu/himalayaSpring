package com.himalaya.aop.advisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.himalaya.aop.service.IService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月4日 下午4:33:53
* Description
*/
public class DynamicPointcut extends DynamicMethodMatcherPointcut{

	private static List<String> specialList = new ArrayList<String>();
	
	static{
		specialList.add("fred");
		specialList.add("wendy");
	}
	
	/**
	 * StaticMethodFilter must be override
	 * otherwise, static method will check every time
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter(){
			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("call getClassFilter to check " + clazz.getName());
				return IService.class.isAssignableFrom(clazz);
			}
		};
	}
	
	/**
	 * StaticMethodFilter must be override
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("call matches to check method " + method.getName());
		return "update".equals(method.getName());
	}
	
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("call matches to check args " + method.getName());
		String param = (String)args[0];
		return specialList.contains(param);
	}
}
