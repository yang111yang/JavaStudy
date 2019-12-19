package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试sql语句的执行和sql注入
 * @author liujy
 *
 */
public class TestJDBC02 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			
			stat = conn.createStatement();
//			String sql = "INSERT INTO t_user (username,pwd,regTime) VALUES ('赵六','6666',NOW());";
//			stat.execute(sql);
			
			// 测试sql注入，Statement容易出现sql注入
			String id = "6 or 1=1";
			String sql = "delete from t_user where id="+id;
			stat.execute(sql);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
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
