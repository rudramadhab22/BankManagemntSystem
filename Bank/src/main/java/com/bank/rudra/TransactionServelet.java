package com.bank.rudra;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/trsns")
public class TransactionServelet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","session expired");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else {
			String raccno=req.getParameter("accno");
			String saccno=(String) hs.getAttribute("accnoo");
			Long amount=Long.parseLong(req.getParameter("amount"));
			int g=new TransactionDao().transcation(amount, saccno, raccno);
			if(g>0) {
				req.setAttribute("msg","transaction sucessfull");
				req.getRequestDispatcher("msg.jsp").forward(req, resp);
				
			}
		}
	}
	

}
