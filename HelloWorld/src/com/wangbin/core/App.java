package com.wangbin.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 
 * @author Íõ±ó
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloBean");
		helloWorld.printHello();*/
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OutputHelper outputHelper =(OutputHelper) context.getBean("outputHelper");
		outputHelper.outputStr();*/
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
		customerDao.insertCustomer(new Customer(1,"wangbin",24));
		
		Customer customer = customerDao.findByCustomerId(1);
		System.out.println(customer);
		
	}

}
