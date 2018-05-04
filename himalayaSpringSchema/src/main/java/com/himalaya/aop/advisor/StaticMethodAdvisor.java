package com.himalaya.aop.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import com.himalaya.aop.service.IService;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年5月4日 下午4:02:10
* Description
*/
public class StaticMethodAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "save".equals(method.getName());
	}

	public ClassFilter getClassFilter() {
		return new ClassFilter(){
			@Override
			public boolean matches(Class<?> clazz) {
				return IService.class.isAssignableFrom(clazz);
			}
		};
	}
}
