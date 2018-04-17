package com.wangbin.jdbc.dao;

import com.wangbin.jdbc.model.Customer;

/**
 * 操作数据库的dao.
 * @author wangbin
 *
 */
public interface CustomerDao {

	public void insertCustomer(Customer customer);
	
	public Customer findByCustomerId(int cusId);
}
