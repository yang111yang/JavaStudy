package com.liu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liu.dao.UserDao;
import com.liu.vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserDao(String name) {
		//创建jdbc连接对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建存储对象
		User user = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC","root","123456");
			//创建sql命令
			String sql = "select * from users where uname=?";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, name);
			//执行sql
			rs = ps.executeQuery();
			//遍历结果集
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setDes(rs.getString("des"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			try {
				if (rs != null) {
					rs.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//返回结果
		return user;
	}

}
