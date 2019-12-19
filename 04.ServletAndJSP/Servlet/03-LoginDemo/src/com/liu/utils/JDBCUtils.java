package com.liu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection() {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			return conn; // 目前先直接建立连接，后期会增加连接池功能
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	
	
	/**
	 * 释放资源
	 * @param ps
	 * @param conn
	 * @param rs
	 */
	public static void close(Statement ps, Connection conn, ResultSet rs) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 * @param ps
	 * @param conn
	 */
	public static void close(Statement ps, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
