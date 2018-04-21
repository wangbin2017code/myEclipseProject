package com.wangbin.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 
 * @author 王斌
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
		
		 ApplicationContext context = new
		 ClassPathXmlApplicationContext("applicationContext.xml"); 
		 CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
		 customerDao.insertCustomer(new Customer(1l,"wangbin",24l));
		 
		 Customer customer = customerDao.findByCustomerId(1);
		 System.out.println(customer);
		 

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
		/*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) context.getBean("customerJdbcDaoSupportImpl");*/
		// customerDao.insertCustomer(new Customer(4, "琳达", 54));
		// Customer customer = customerDao.findByCustomerId(4);
		/*
		 * List<Customer> customesList = customerDao.findAllCustomer();
		 * customesList.forEach(customer -> { System.out.println(customer); });
		 */

		// 批量插入数据
		/*
		 * List<Customer> customers = new ArrayList<Customer>(); Customer
		 * customer = new Customer(10l, "孙悟空", 100l); Customer customer1 = new
		 * Customer(11l, "沙僧", 500l); Customer customer2 = new Customer(12l,
		 * "唐僧", 1000l); Customer customer3 = new Customer(13l, "猪八戒", 200l);
		 * customers.add(customer); customers.add(customer1);
		 * customers.add(customer2); customers.add(customer3);
		 * customerDao.insertBatch(customers);
		 * 
		 * int cnt = customerDao.selectAllCustomerCnt(); String name =
		 * customerDao.selectNameById(12); System.out.println("总行数:" + cnt + " "
		 * + "name:" + name);
		 */

		/*String sql2 = "UPDATE CUSTOMER SET NAME='WO'";
		customerDao.insertBatchSql(sql2);
		String name = customerDao.selectNameById(12);
		System.out.println("name:" + name);*/

	}

}
