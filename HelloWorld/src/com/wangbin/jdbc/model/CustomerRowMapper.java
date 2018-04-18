package com.wangbin.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * �Զ���RowMapper,��ӳ��jdbcTemplate��ѯ����.
 * 
 * @author wangbin
 *
 */
public class CustomerRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer customer = new Customer();
		customer.setCustId(rs.getLong("CUST_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setAge(rs.getLong("AGE"));
		return customer;
	}

}
