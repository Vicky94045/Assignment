package com.smartekprog.company.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/DeleteCompany")
public class DeleteCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCompany() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entering");
		
		PrintWriter out=response.getWriter();
		//int company_id=Integer.parseInt(request.getParameter("cid"));
		HttpSession sess=request.getSession();
		
		
		int company_id=(int) sess.getAttribute("id");
		System.out.println("Emp id : "+company_id);
		String sql="delete from company where company_id="+company_id;
		jdbcconnect con=new jdbcconnect();
		Statement st=con.connect();
		try {
			int error=st.executeUpdate(sql);
			System.out.println(error);
			if(error==1)
			{
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EmpRetrive.jsp");
			dispatcher.forward(request, response);
			}else if(error==0)
			{
				out.println("No Company present with that id");	
			}
		}catch (SQLIntegrityConstraintViolationException em) {
			out.println("Cant delete employee who have employees in them");			
		}
		catch (SQLException e) {
			System.out.println("Record not found");
			out.print("Record not found");
		}
		
		
	}

}
