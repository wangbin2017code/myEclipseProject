package com.wangbin.jdbc.dao;

import java.util.List;

import com.wangbin.jdbc.model.Customer;

/**
 * �������ݿ��dao.
 * 
 * @author wangbin
 *
 */
public interface CustomerDao {

	// ����
	public void insertCustomer(Customer customer);

	// ����ID��ѯ��Ϣ
	public Customer findByCustomerId(int cusId);

	// ��ѯ������Ϣ
	public List<Customer> findAllCustomer();

	// ��ѯ��ѯ��¼��
	public int selectAllCustomerCnt();

	// ��ѯĳ������
	public String selectNameById(int custId);
	
	// ������������
	public void insertBatch(List<Customer> customers);
	
	// ʹ��sql������������
	public void insertBatchSql(String sql);
}
