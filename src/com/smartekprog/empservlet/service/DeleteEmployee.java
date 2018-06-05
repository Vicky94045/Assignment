package com.smartekprog.empservlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartekprog.connect.jdbcconnect;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteEmployee() {
        super();    
    }

/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside delete emp");
	
	int eid=Integer.parseInt(request.getParameter("ide"));
	System.out.println("Emp id : "+eid);
	PrintWriter out=response.getWriter();		
	
//	int eid= Integer.parseInt(request.getParameter("eid"));
	jdbcconnect con=new jdbcconnect();
	Statement st=con.connect();
	String sql="delete from employee where empno="+eid;
	try {
		int i=st.executeUpdate(sql);
		if(i==1) {
			//out.println("Record deleted");
			//RequestDispatcher dis=getServletContext().getRequestDispatcher("/EmployeeRetrive");
			//dis.forward(request, response);		
			response.getWriter().write("Record deleted");
		}else {
			//out.print("Record not deleted");
			response.getWriter().write("Record Not deleted");
		}
	} catch (SQLException e) {		
		e.printStackTrace();
	}
	
		
	}

}
