package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试数据库连接
 * @author liujy
 *
 */
public class TestJDBC01 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
