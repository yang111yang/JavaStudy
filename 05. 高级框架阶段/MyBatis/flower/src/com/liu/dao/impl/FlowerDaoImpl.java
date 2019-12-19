package com.liu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.dao.FlowerDao;
import com.liu.pojo.Flower;

public class FlowerDaoImpl implements FlowerDao {

	@Override
	public List<Flower> selAll() {
		//创建JDBC对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//创建数据存储对象
		List<Flower> list = new ArrayList<>();
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql
			String sql = "select * from flower";
			//创建sql对象
			ps = conn.prepareStatement(sql);
			//执行sql
			rs = ps.executeQuery();
			//遍历结果集
			while (rs.next()) {
				Flower flower = new Flower();
				flower.setId(rs.getInt("id"));
				flower.setName(rs.getString("name"));
				flower.setPrice(rs.getDouble("price"));
				flower.setProduction(rs.getString("production"));
				list.add(flower);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//关闭资源
		//返回结果
		return list;
	}

	@Override
	public int addFlower(Flower flower) {
		//创建JDBC对象
		Connection conn = null;
		PreparedStatement ps = null;
		//创建数据存储对象
		int index = 0;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useSSL=false&serverTimezone=UTC", "root", "123456");
			//创建sql
			String sql = "insert into flower values(default,?,?,?)";
			//创建sql对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, flower.getName());
			ps.setDouble(2, flower.getPrice());
			ps.setString(3, flower.getProduction());
			//执行sql
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//关闭资源
		//返回结果
		return index;
	}

}
