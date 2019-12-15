package com.manager.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.manager.dao.UserDao;
import com.manager.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		//创建jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建存储数据使用的对象
		User u = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql命令
			String sql = "select * from t_user where uname=? and pwd=?";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行sql
			rs = ps.executeQuery();
			//遍历执行结果
			while (rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
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
		
		return u;
	}

	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		//创建jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		int index = -1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql命令
			String sql = "update t_user set pwd=? where uid=?";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			//执行sql
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
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
				
		return index;
	}

	@Override
	public List<User> userShowDao() {
		//创建jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建存储对象
		List<User> lu = new ArrayList<User>();
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql命令
			String sql = "select * from t_user";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			//执行命令
			rs = ps.executeQuery();
			//遍历查询结果
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				//将User对象添加到List中
				lu.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
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
		//返回结果
		return lu;
	}

	@Override
	public int userRegDao(User u) {
		//创建jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建存储数据使用的对象
		int index = -1;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database?useSSL=false&serverTimezone=UTC&characterEncoding=utf8", "root", "123456");
			//创建sql命令
			String sql = "insert into t_user values(default,?,?,?,?,?)";
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
			//执行sql
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
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
		return index;
	}

}
