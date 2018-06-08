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
import com.smartekprog.empservlet.DAO.EmployeeDAO;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteEmployee() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside delete emp");
	
	int eid=Integer.parseInt(request.getParameter("ide"));
	System.out.println("Emp id : "+eid);
	EmployeeDAO edoa=new EmployeeDAO();
	if(edoa.delete(eid)) {
		response.getWriter().write("Record deleted");
	}else {
		response.getWriter().write("Record not deleted");
	}
	}
}
