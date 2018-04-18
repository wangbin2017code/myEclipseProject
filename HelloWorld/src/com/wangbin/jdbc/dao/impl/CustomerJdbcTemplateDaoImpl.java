package com.wangbin.jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;
import com.wangbin.jdbc.model.CustomerRowMapper;

/**
 * ͨ��spring��jdbcTemplate���������ݿ�.
 * 
 * @author wangbin
 *
 */
public class CustomerJdbcTemplateDaoImpl implements CustomerDao {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertCustomer(Customer customer) {

		String sql = "INSERT INTO CUSTOMER" + "(CUST_ID,NAME,AGE) VALUES(?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });
	}

	@Override
	public Customer findByCustomerId(int cusId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { cusId },
				new CustomerRowMapper());
		return customer;
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectAllCustomerCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectNameById(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBatch(List<Customer> customers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBatchSql(String sql) {
		// TODO Auto-generated method stub
		
	}

}
