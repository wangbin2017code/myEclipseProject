package com.wangbin.ssh.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends BaseSpring{

	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory) super.applicationContext.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
}
