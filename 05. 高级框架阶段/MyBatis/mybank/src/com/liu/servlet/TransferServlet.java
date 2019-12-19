package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.pojo.Account;
import com.liu.pojo.PageInfo;
import com.liu.service.AccountService;
import com.liu.service.impl.AccountServiceImpl;
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	AccountService as = new AccountServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accOutAccNo"));
		accIn.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accIn.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accInAccNo"));
		accOut.setName(req.getParameter("accInName"));
		int code = as.transfer(accIn, accOut);
		if (code==5) {
			//转账成功，重定向到log.jsp页面
			resp.sendRedirect("/mybank/show");
		} else {
			//转账失败，重定向到error.jsp页面
			HttpSession session = req.getSession();
			session.setAttribute("code", code);
			resp.sendRedirect("/mybank/error/error.jsp");
		}
	}
}
