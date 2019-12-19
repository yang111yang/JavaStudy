package com.liu.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Object[] 封装一条记录
 * 使用List<Object[]>封装多条记录
 * @author liujy
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		Connection conn = JDBCUtils.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Object[] objs = new Object[3];
				objs[0] = rs.getObject(1);
				objs[1] = rs.getObject(2);
				objs[2] = rs.getObject(3);
				list.add(objs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(ps, conn, rs);
		}
		
		for (Object[] objs : list) {
			System.out.println(objs[0] + "-->" + objs[1] + "-->" + objs[2]);
		}
	}

}
