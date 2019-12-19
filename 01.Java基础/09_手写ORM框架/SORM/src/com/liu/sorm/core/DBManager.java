package com.liu.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.liu.sorm.bean.Configuration;
import com.liu.sorm.pool.DBConnPool;

/**
 * 根据配置信息，维持连接对象的管理(增加连接池功能)
 * @author liujy
 *
 */
public class DBManager {
	
	/**
	 * 配置信息对象
	 */
	private static Configuration conf;
	
	private static DBConnPool pool;
	/**
	 * 静态代码化初始化配置信息
	 */
	static { 
		
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		
	}

	
	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection() {
		if (pool == null) {
			pool = new DBConnPool();
		}
		return pool.getConnection(); // 目前先直接建立连接，后期会增加连接池功能
	}
	
	/**
	 * 创建新的Connection对象
	 * @return
	 */
	public static Connection createConn(){
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());     //直接建立连接，后期增加连接池处理，提高效率！！！
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 释放资源
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
		pool.close(conn);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
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
	
	/**
	 * 获取Configuration对象
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
	
	
}
