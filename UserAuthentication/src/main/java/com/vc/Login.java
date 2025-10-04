package com.vc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 
@WebServlet(description = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Login() {
		super();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.getWriter().append("served at :").append(request.getContextPath());
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("tbName");
		String password = request.getParameter("tbPwd");
		String phonenumber = request.getParameter("tbphone"); 

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "admin");
			
			PreparedStatement pt = con.prepareStatement("select u_name from userlogin where u_name = ? and u_password = ? and u_phonenumber = ?");
			
			pt.setString(1, username);
			pt.setString(2, password);
			pt.setString(3, phonenumber);
			
			ResultSet s = pt.executeQuery();
			
			if(s.next()) {
				RequestDispatcher rs = request.getRequestDispatcher("home.html");
				rs.forward(request, response);
			}else {
				RequestDispatcher rs = request.getRequestDispatcher("Error.html");
				rs.forward(request, response);
			}
			
		
			
			con.close();
			pt.close();
			
		} catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}
		
		
			
		
	}

}
