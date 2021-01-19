package org.servlet.Include;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prdname=(String) req.getAttribute("pdname");
		int prdqty=Integer.parseInt((String)req.getAttribute("pdqty"));
		double price=45000;
		
		//BUSINESS LOGIC
		double total_Amount=prdqty*price;
		
		//PERSISTENCE LOGIC
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.product values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, prdname);
			pstmt.setInt(2, prdqty);
			pstmt.setDouble(3,price);
			pstmt.setDouble(4, total_Amount);
			pstmt.executeUpdate();
			
			req.setAttribute("total_Amount", total_Amount);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
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
