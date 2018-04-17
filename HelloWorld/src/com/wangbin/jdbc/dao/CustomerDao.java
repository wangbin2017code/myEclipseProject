package com.wangbin.jdbc.dao;

import com.wangbin.jdbc.model.Customer;

/**
 * �������ݿ��dao.
 * @author wangbin
 *
 */
public interface CustomerDao {

	public void insertCustomer(Customer customer);
	
	public Customer findByCustomerId(int cusId);
}
