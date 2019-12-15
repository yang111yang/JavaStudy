package com.liu.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试BLOB		二进制大对象的使用
 * @author liujy
 *
 */
public class TestJDBC11 {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			conn = JDBCUtils.getMysqlConnection();
			
			ps = conn.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 22748);
			rs = ps.executeQuery();
			while (rs.next()) {
				Blob blob = rs.getBlob("headImage");
				is = blob.getBinaryStream();
				os = new FileOutputStream("a.jpg");
				int temp = 0;
				while ((temp = is.read())!=-1) {
					os.write(temp);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			JDBCUtils.close(ps, conn);
		}
	}
	
	
}
