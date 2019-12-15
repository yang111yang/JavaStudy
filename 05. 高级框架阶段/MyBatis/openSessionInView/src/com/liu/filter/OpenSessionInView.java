package com.liu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.liu.util.MyBatisUtil;
/**
 * ������
 * @author Administrator
 *
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchain)
			throws IOException, ServletException {
		SqlSession session = MyBatisUtil.getSession();
		try {
			fchain.doFilter(req, resp);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSession();
		}
	}

}
