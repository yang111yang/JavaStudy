package com.liu.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.liu.user.Servlet;

public class Dispatcher implements Runnable {
	
	private Request request;
	private Response response;
	private Socket client;

	public Dispatcher(Socket client) {
		this.client = client;
		try {
			request = new Request(client);
			response = new Response(client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			if (request.getReqUrl() == null || request.getReqUrl().equals("")) {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				response.print(new String(is.readAllBytes()));
				response.pushToBrowser(200);
				is.close();
				return;
			}
			Servlet servlet = WebApp.getServletFromUrl(request.getReqUrl());
			if (servlet != null) { // 閹存劕濮�
				servlet.service(request, response);
				response.pushToBrowser(200);
			} else {
				InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				response.print(new String(is.readAllBytes()));
				response.pushToBrowser(404);
				is.close();
			}
		} catch(Exception e) {
			response.pushToBrowser(500);
			System.out.println("閺堝秴濮熼崳銊╂晩鐠囷拷");
		}
		release();
	}
	
	public void release() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
