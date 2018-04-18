package com.wangbin.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.wangbin.jdbc.dao.CustomerDao;
import com.wangbin.jdbc.model.Customer;

/**
 * 通过jdbc实行数据库的操作.
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
			ps.setLong(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setLong(3, customer.getAge());
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
				customer = new Customer(rs.getLong("CUST_ID"),rs.getString("NAME"),rs.getLong("AGE"));
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
