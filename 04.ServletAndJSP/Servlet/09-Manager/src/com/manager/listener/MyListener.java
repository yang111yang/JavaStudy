package com.manager.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("count", 0);
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		ServletContext sc = hse.getSession().getServletContext();
		int count = (int) sc.getAttribute("count");
		sc.setAttribute("count", ++count );
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		ServletContext sc = hse.getSession().getServletContext();
		int count = (int) sc.getAttribute("count");
		sc.setAttribute("count", --count);
	}

}
