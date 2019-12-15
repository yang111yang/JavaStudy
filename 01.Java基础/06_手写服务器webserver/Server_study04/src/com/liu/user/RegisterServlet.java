package com.liu.user;

import com.liu.server.core.Request;
import com.liu.server.core.Response;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		String uname = request.getParaValue("uname");
		String[] favs = request.getParaValues("fav");
		response.print("<html>");
		response.print("<head>");
		response.print("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">");
		response.print("<title>");
		response.print("注册成功");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("用户名：" + uname);
		response.print("我的爱好是：" );
		for (String fav : favs) {
			if (fav.equals("0")) {
				response.print("乒乓球" );
			} else if (fav.equals("1")) {
				response.print("羽毛球" );
			} else if (fav.equals("2")) {
				response.print("网球" );
			}
		}
		response.print("</body>");
		response.print("</html>");
	}

}
