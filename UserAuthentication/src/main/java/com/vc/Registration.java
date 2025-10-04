package com.vc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Registration
 */
@WebServlet(description = "Registration", urlPatterns = { "/Registration" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("tname");
		String password = request.getParameter("tpassword");
		String phonenumber = request.getParameter("tphone"); 

		
		
		try {
//			step :1)....loading driver is cleared
			Class.forName("com.mysql.cj.jdbc.Driver");

//			step :2)establish connection between java to mysql (jdbc connection is done....)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "admin");

//			know creating inserting data

			PreparedStatement pt = con.prepareStatement("insert into userlogin values(?,?,?)");

			pt.setString(1, username);
			pt.setString(2, password);
			pt.setString(3, phonenumber);

//			execute it means uploading data into database 
//			(taking the data from the user and storing it into db)

			int result = pt.executeUpdate();
			
			System.out.println("successfully inserted the data" + result);
			
			con.close();
			pt.close();

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		}
		RequestDispatcher rs = request.getRequestDispatcher("login.html");
		rs.forward(request, response);

	}

}
