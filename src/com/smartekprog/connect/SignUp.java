package com.smartekprog.connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("un");
		String pass=request.getParameter("pw");
		String email=request.getParameter("email");
		jdbcconnect jd = new jdbcconnect();
		Statement st = jd.connect();
		String sql = "insert into users values('"+user+"','"+pass+"','"+email+"')";
		
		try {
			int check = st.executeUpdate(sql);
			System.out.println("check: " + check);
			if (check > 0) {
				out.println("User created");
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting data :" + e);
			String error=e.toString();
			if(error.contains("Duplicate"))
					{					
					request.setAttribute("present","User Alredy Present");					
					RequestDispatcher res=getServletContext().getRequestDispatcher("/SignUp.jsp");
					res.forward(request, response);				
					}else {					
						out.println("Error " + e);
					}
		
		
	}
}
}
