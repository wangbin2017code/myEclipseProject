package com.wangbin.jdbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		getJdbcTemplate().update(sql, new Object[] { customer.getCustId(), customer.getName(), customer.getAge() });

	}

	@Override
	public Customer findByCustomerId(int cusId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";
		// 查询单行数据
		// 1.自定义RowMapper
		// Customer customer = (Customer) getJdbcTemplate().queryForObject(sql,
		// new Object[]{cusId},new CustomerRowMapper());
		// 2.BeanPropertyRowMapper

		Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { cusId },
				new BeanPropertyRowMapper<Customer>(Customer.class));

		return customer;
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> customers = new ArrayList<Customer>();
		// 查询多行
		// 1.手动映射
		String sql1 = "SELECT * FROM CUSTOMER";
		/*
		 * List<Map<String, Object>> rows =
		 * getJdbcTemplate().queryForList(sql1); for (Map<String, Object> row :
		 * rows) { Customer customer = new Customer(); customer.setCustId((Long)
		 * row.get("CUST_ID")); customer.setName((String) row.get("NAME"));
		 * customer.setAge((Long) row.get("AGE")); customers.add(customer); }
		 */

		// 2.BeanPropertyRowMapper
		customers = getJdbcTemplate().query(sql1, new BeanPropertyRowMapper<Customer>(Customer.class));
		return customers;
	}

	@Override
	public int selectAllCustomerCnt() {

		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		int cnt = getJdbcTemplate().queryForInt(sql);
		return cnt;
	}

	@Override
	public String selectNameById(int custId) {
		String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID =?";
		String name = getJdbcTemplate().queryForObject(sql, new Object[] { custId }, String.class);
		return name;
	}

	@Override
	public void insertBatch(List<Customer> customers) {
		String sql = "INSERT INTO CUSTOMER(CUST_ID,NAME,AGE) VALUES(?,?,?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedstatement, int i) throws SQLException {
				Customer customer = customers.get(i);
				preparedstatement.setLong(1, customer.getCustId());
				preparedstatement.setString(2, customer.getName());
				preparedstatement.setLong(3, customer.getAge());
			}

			@Override
			public int getBatchSize() {
				return customers.size();
			}
		});
	}

	@Override
	public void insertBatchSql(String sql) {
		getJdbcTemplate().batchUpdate(new String[] { sql });
	}

}
