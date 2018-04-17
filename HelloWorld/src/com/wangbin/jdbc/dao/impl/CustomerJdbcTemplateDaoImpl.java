package com.wangbin.jdbc.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;
import com.wangbin.jdbc.model.CustomerRowMapper;

/**
 * 通过spring的jdbcTemplate来操作数据库.
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
		jdbcTemplate.update(sql, new Object[] { customer.getCusId(), customer.getName(), customer.getAge() });
	}

	@Override
	public Customer findByCustomerId(int cusId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		Customer customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { cusId },
				new CustomerRowMapper());
		return customer;
	}

}
