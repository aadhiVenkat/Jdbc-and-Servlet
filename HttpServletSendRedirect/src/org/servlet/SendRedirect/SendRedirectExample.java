package org.servlet.SendRedirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRedirectExample extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword=req.getParameter("key");
		
		resp.setContentType("text/html");
		resp.sendRedirect("https://www.google.co.in/#q="+keyword);
	}
}
