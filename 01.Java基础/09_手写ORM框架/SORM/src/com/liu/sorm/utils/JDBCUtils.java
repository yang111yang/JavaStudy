package com.liu.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装JDBC的常用操作
 * @author liujy
 *
 */
public class JDBCUtils {
	
	/**
	 * 给sql传参
	 * @param ps
	 * @param params	参数
	 */
	public static void handleParams(PreparedStatement ps, Object[] params) {
		if (params != null) {
			for (int i = 1; i < params.length+1; i++) {
				try {
					ps.setObject(i, params[i-1]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
