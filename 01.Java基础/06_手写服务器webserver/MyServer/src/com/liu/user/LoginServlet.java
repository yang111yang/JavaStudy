package com.liu.user;

import com.liu.server.Request;
import com.liu.server.Response;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
		response.print("<title>");
		response.print("登录");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("登录成功："+ request.getParaValue("uname"));
		response.print("</body>");
		response.print("</html>");
	}

}
