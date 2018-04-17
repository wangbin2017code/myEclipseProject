package com.wangbin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 
 * @author ����
 *
 */
public class App {

	public static void main(String[] args) {

		/*
		 * ApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); HelloWorld
		 * helloWorld = (HelloWorld) applicationContext.getBean("helloBean");
		 * helloWorld.printHello();
		 */

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml");
		 * OutputHelper outputHelper =(OutputHelper)
		 * context.getBean("outputHelper"); outputHelper.outputStr();
		 */

		/** spring jdbc */
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); CustomerDao
		 * customerDao = (CustomerDao) context.getBean("customerDao");
		 * customerDao.insertCustomer(new Customer(1,"wangbin",24));
		 * 
		 * Customer customer = customerDao.findByCustomerId(1);
		 * System.out.println(customer);
		 */

		/** spring jdbcTemplage */
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); CustomerDao
		 * customerDao = (CustomerDao)
		 * context.getBean("customerJdbcTemplateDao");
		 * customerDao.insertCustomer(new Customer(2, "zhangsan", 34));
		 * 
		 * Customer customer = customerDao.findByCustomerId(2);
		 * System.out.println(customer);
		 */

		/**
		 * spring jdbcDaoSupport
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerJdbcDaoSupportImpl");
		customerDao.insertCustomer(new Customer(3, "lisi", 54));

	}

}
