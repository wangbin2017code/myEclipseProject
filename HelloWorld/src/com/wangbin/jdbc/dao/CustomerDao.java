package com.wangbin.jdbc.dao;

import java.util.List;

import com.wangbin.jdbc.model.Customer;

/**
 * 操作数据库的dao.
 * 
 * @author wangbin
 *
 */
public interface CustomerDao {

	// 新增
	public void insertCustomer(Customer customer);

	// 根据ID查询信息
	public Customer findByCustomerId(int cusId);

	// 查询所有信息
	public List<Customer> findAllCustomer();

	// 查询查询记录数
	public int selectAllCustomerCnt();

	// 查询某列数据
	public String selectNameById(int custId);
	
	// 批量插入数据
	public void insertBatch(List<Customer> customers);
	
	// 使用sql批量插入数据
	public void insertBatchSql(String sql);
}
