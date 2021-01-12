package org.student.HttpRequestExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestApp extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException{
		String name=req.getParameter("na");
		int id=Integer.parseInt(req.getParameter("id"));
		double perc=Double.parseDouble(req.getParameter("pe"));
		String dep=req.getParameter("de");
			
		Connection con=null;
		PreparedStatement pst=null;
		String qry="insert into btm.studentdetails values(?,?,?,?)";
		PrintWriter out=resp.getWriter();
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			pst=con.prepareStatement(qry);
			pst.setString(1,name);
			pst.setInt(2, id);
			pst.setDouble(3, perc);
			pst.setString(4, dep);
			pst.executeUpdate();
			out.println("<http><body bgcolor='yellow'><h1>Data Stored Successfully<br><a href='Registration.html'>BACK</a></h1></body></html>");		
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
			out.flush();
			out.close();
		}		
		
	}
}
