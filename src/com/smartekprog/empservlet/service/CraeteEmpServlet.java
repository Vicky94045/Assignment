package com.smartekprog.empservlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartekprog.company.DAO.CompanyDAO;
import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;
import com.smartekprog.empservlet.DAO.EmployeeDAO;

/**
 * Servlet implementation class CraeteEmpServlet
 */
@WebServlet("/CraeteEmpServlet")
public class CraeteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CraeteEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		Employee emp = new Employee();
		emp.setEmpNo(Integer.parseInt(request.getParameter("Empno")));
		emp.setFirst_Name(request.getParameter(("Fname")));
		emp.setLast_Name(request.getParameter("Lname"));
		emp.setAge(Integer.parseInt(request.getParameter("Age")));
		emp.setMailId(request.getParameter("Mail"));
		emp.setAddress(request.getParameter("Address"));
		emp.setSalary(Integer.parseInt(request.getParameter("Salary")));
		emp.setGender(request.getParameter("gender"));
		emp.setMobile_No(request.getParameter("Mobile"));
		emp.setCompany_Name(request.getParameter("cname"));
		System.out.println("Company name= "+emp.getCompany_Name());			
		emp.setBirthdate(java.sql.Date.valueOf(request.getParameter("dob")));
		emp.setHire_date(java.sql.Date.valueOf(request.getParameter("Hiredate")));		
		EmployeeDAO edao=new EmployeeDAO();				
		CompanyDAO cdao=new CompanyDAO();
		emp.setCompany_id(cdao.getCompID(emp.getCompany_Name()));
		if (cdao.CheckComp(emp.getCompany_Name())) {			
			if(edao.create(emp))
			{	
				RequestDispatcher res=getServletContext().getRequestDispatcher("/Select.jsp");
				res.forward(request, response);
			}else {	
				System.out.println("Record not updated");
			} 
		} else {
			out.print("Company id not present");
		}
	}
}
