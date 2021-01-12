package org.student.HttpRequestExample;

import javax.servlet.http.HttpServlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HttpRequestGet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
		int id=Integer.parseInt(req.getParameter("id"));
		
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry="select *from btm.studentdetails where id=?";
		PrintWriter out=resp.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			out.println("<html><body bgcolor='#7ba9db'><h1><u>StudentDetails</u><br>Name: "+rs.getString(1)+"<br>"
					+ "Id: "+rs.getInt(2)+"<br>Percentage: "+rs.getDouble(3)+"<br>Department: "+rs.getString(4)+"<br><br><br><a href='Retrive.html'>Back</a></h1></body></html>");
			}
			out.flush();
			out.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		}	
		
	}

}
