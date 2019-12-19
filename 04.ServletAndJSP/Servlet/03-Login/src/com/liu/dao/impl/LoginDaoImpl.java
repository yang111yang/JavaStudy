package com.liu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liu.bean.User;
import com.liu.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User checkLoginDao(String uname, String pwd) {
		//����jdbc����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�������ݴ洢����
		User user = null;
		try{
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//����sql����
			String sql = "select * from t_user where uname=? and pwd=?";
			//����sql�������
			ps = conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			//ִ��sql
			rs = ps.executeQuery();
			//����ִ�н��
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		//����
		return user;
	}

	@Override
	public User checkIdDao(String id) {
		//����jdbc����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//�������ݴ洢����
		User user = null;
		try{
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//����sql����
			String sql = "select * from t_user where id=?";
			//����sql�������
			ps = conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setObject(1, id);
			//ִ��sql
			rs = ps.executeQuery();
			//����ִ�н��
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		//����
		return user;
	}

}
