package org.servlet.Include;

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
		rd.include(req, resp);
		
		 double total_Amount = (double)req.getAttribute("total_Amount");
		//PRESENTATION LOGIC
		PrintWriter out=resp.getWriter();
		out.println("<h1>Product Name:  "+pname+"<br>Product Qty:  "+pqty+"<br>Total Amount:  "+total_Amount+"<br><br><a href=product.html>Back</a></h1>");
	}

}
