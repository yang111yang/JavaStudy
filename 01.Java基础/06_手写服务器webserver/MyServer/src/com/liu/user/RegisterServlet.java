package com.liu.user;

import com.liu.server.Request;
import com.liu.server.Response;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("注册成功");
	}

}
