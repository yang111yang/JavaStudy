package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * 测试时间处理(java.sql.Date,java.sql.Time,java.sql.Timestamp)
 * @author liujy
 *
 */
public class TestJDBC07 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			long start = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				ps = conn.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?)");
				ps.setObject(1, "刘建阳");
				ps.setObject(2, "123456");
				int d = 100000000+new Random().nextInt(1000000000);
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-d);
				java.sql.Timestamp stamp = new java.sql.Timestamp(System.currentTimeMillis()-d);
				ps.setObject(3, date);
				ps.setObject(4, stamp);
				ps.executeUpdate();
				
			}
			long end = System.currentTimeMillis();
			System.out.println("插入数据成功，耗时："+(end-start));
			
			
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
