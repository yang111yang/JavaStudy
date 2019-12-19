package com.liu.user;

import com.liu.server.core.Request;
import com.liu.server.core.Response;

public interface Servlet {

	void service(Request request, Response response);
}
