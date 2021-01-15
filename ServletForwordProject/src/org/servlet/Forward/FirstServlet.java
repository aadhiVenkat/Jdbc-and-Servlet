package org.servlet.Forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname=req.getParameter("pname");
		String pqty=req.getParameter("pqty");
		//ADD REQUEST OBJECT INTO SCOPE
		req.setAttribute("pdname", pname);
		req.setAttribute("pdqty", pqty);
	
		RequestDispatcher rd=req.getRequestDispatcher("ss");		
		rd.forward(req, resp);
		
		
	}

}
