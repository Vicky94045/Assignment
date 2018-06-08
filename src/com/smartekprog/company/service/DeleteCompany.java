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

import com.smartekprog.company.DAO.CompanyDAO;
import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/DeleteCompany")
public class DeleteCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DeleteCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Comp delete");	
		int company_id=Integer.parseInt(request.getParameter("cid"));
		System.out.println("Company id : "+company_id);
		CompanyDAO cdao=new CompanyDAO();
		if(cdao.deletecomp(company_id))
		{
			response.getWriter().write("Record deleted");
		}else {
			response.getWriter().write("Record not deleted Company may have employees in it");
		}
	
		
		
	}
}
