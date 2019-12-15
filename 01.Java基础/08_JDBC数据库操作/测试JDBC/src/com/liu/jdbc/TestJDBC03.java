package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试PreparedStatement
 * @author liujy
 *
 */
public class TestJDBC03 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			
			String sql = "INSERT INTO t_user (username,pwd,regTime) VALUES (?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "张三");
			ps.setObject(2, "123456");
			ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	
	
}
