package com.liu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/pool")
public class DemoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//使用JNDI :java 命名目录接口技术.获取数据库连接池
			//Context是context.xml文件的对象
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/test");
			//获取数据库连接
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from flower");
			ResultSet rs = ps.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			while (rs.next()) {
				out.write(rs.getInt(1) + "&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"<br/>");
			}
			out.flush();
			rs.close();
			ps.close();
			conn.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
