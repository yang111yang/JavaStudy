package com.liu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	/**
	 * ��ȡConnection����
	 * @return
	 */
	public static Connection getConnection() {
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			return conn; // Ŀǰ��ֱ�ӽ������ӣ����ڻ��������ӳع���
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	
	
	/**
	 * �ͷ���Դ
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
	 * �ͷ���Դ
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
