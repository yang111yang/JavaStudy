package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试批处理Batch
 * @author liujy
 *
 */
public class TestJDBC05 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			
			long start = System.currentTimeMillis();
			conn.setAutoCommit(false); // 将事务设为不自动提交
			stat = conn.createStatement();
			for (int i = 0; i < 20000; i++) {
				stat.addBatch("insert into t_user (username,pwd,regTime) values ('liu"+i+"','66666',now())");
			}
			stat.executeBatch();
			conn.commit(); // 提交事务
			long end = System.currentTimeMillis();
			System.out.println("添加20000条数据，耗时："+(end-start));
			
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
