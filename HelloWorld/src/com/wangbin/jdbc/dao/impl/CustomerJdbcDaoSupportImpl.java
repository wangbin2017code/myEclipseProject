package com.wangbin.jdbc.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 通过继承jdbcDaoSupport来简化数据操作，不需要设置数据源.
 * 
 * @author wangbin
 *
 */
public class CustomerJdbcDaoSupportImpl extends JdbcDaoSupport implements CustomerDao {

	@Override
	public void insertCustomer(Customer customer) {

		String sql = "INSERT INTO CUSTOMER" + "(CUST_ID,NAME,AGE) VALUES(?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { customer.getCusId(), customer.getName(), customer.getAge() });

	}

	@Override
	public Customer findByCustomerId(int cusId) {
		// TODO Auto-generated method stub
		return null;
	}

}
