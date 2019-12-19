package com.liu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liu.bean.User;
import com.liu.dao.LoginDao;
import com.liu.utils.JDBCUtils;

public class LoginDaoImpl implements LoginDao {

	/**
	 * 使用jdbc从数据库中查询用户信息
	 */
	@Override
	public User checkLoginDao(String uname, String pwd) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from t_user where uname=? and pwd=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				System.out.println(rs.getString("uname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(ps, conn, rs);
		}
		return u;
	}

	@Override
	public User checkIdDao(String id) {
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from t_user where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				System.out.println(rs.getString("uname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(ps, conn, rs);
		}
		return u;
	}

}
