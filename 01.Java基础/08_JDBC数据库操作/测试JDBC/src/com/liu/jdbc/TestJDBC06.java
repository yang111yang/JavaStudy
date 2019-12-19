package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试事务的基本概念和基本用法
 * @author liujy
 *
 */
public class TestJDBC06 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?useSSL=false&serverTimezone=UTC",
					"root", "123456");
			
			conn.setAutoCommit(false); // JDBC中的事务默认是自动提交的，此处设置为非自动提交
			ps1 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps1.setObject(1, "刘建阳");
			ps1.setObject(2, "123456");
			ps1.executeUpdate();
			System.out.println("插入了一条记录，刘建阳");
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 此处sql语句有问题，执行失败，事务回滚
			ps2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");
			ps2.setObject(1, "邓宇");
			ps2.setObject(2, "123456");
			ps2.executeUpdate();
			System.out.println("插入了一条记录，邓宇");
			
			conn.commit(); // 提交事务
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (ps2 != null) {
					ps2.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps1 != null) {
					ps1.close();
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
