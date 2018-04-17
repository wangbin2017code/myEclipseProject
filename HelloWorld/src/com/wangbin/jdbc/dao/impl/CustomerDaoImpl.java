package com.wangbin.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 通过jdgc实行数据库的操作.
 * @author wangbin
 *
 */
public class CustomerDaoImpl implements CustomerDao {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		
		String sql = "INSERT INTO CUSTOMER"+"(CUST_ID,NAME,AGE) VALUES(?,?,?)";
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, customer.getCusId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
	}

	@Override
	public Customer findByCustomerId(int cusId) {
		
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID=?";
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, cusId);
			Customer customer = null;
			ResultSet rs= ps.executeQuery();
			if(rs.next()){
				customer = new Customer(rs.getInt("CUST_ID"),rs.getString("NAME"),rs.getInt("AGE"));
			}
			rs.next();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e2) {
					// TODO: handle exception
				}
			}
		}
	}

}
