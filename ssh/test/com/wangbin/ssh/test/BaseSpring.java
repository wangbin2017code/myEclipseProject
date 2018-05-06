package com.wangbin.ssh.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author wangbin
 *
 */
public class BaseSpring {
	
	public static ApplicationContext applicationContext;
	
	@Before
	public void getApplicationContext(){
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

}
