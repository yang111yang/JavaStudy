package com.liu.user;

import com.liu.server.Request;
import com.liu.server.Response;

public interface Servlet {

	void service(Request request, Response response);
	
}
