package com.liu.server;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("服务器响应");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("欢迎回来：" + request.getParaValue("uname"));
		response.print("</body>");
		response.print("</html>");
		
	}

}
