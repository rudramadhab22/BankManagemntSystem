package com.bank.rudra;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServelet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acno=req.getParameter("accno");
		String name=req.getParameter("name");
		Accbean ab=new LoginDao().login(acno, name);
		if(ab==null) {
			req.setAttribute("msg","invalid login process");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else {
			HttpSession hs=req.getSession();
			hs.setAttribute("accnoo", ab.getAccno());
			req.getRequestDispatcher("logsucess.jsp").forward(req, resp);
		}
	}

}
