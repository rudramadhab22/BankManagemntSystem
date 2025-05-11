package com.bank.rudra;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/dip")
public class DipositeServelet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 long amount=Long.parseLong(req.getParameter("amount"));
	 System.out.println(amount);
	 HttpSession hs=req.getSession(false);
	 String accno=(String) hs.getAttribute("accnoo");
	 
	 
	
		int k=new DipositeDao().diposite(amount,accno);
		req.setAttribute("msg","diposited");
		if(k>0) {
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		
		
		
		
	}

}
