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
		//声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//声明数据存储对象
		User user = null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql命令
			String sql = "select * from t_user where uname=? and pwd=?";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			//执行sql
			rs = ps.executeQuery();
			//遍历执行结果
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
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
		//返回
		return user;
	}

	@Override
	public User checkIdDao(String id) {
		//声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//声明数据存储对象
		User user = null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql命令
			String sql = "select * from t_user where id=?";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setObject(1, id);
			//执行sql
			rs = ps.executeQuery();
			//遍历执行结果
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
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
		//返回
		return user;
	}

}
