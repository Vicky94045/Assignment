package com.smartekprog.company.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/craeteservlet")
public class CompanyCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter out;

	public CompanyCreateServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();
		Company company = new Company(request.getParameter("cname"),
				request.getParameter("caddress"),request.getParameter("cnumber"),
				request.getParameter("ctype"));

		jdbcconnect jd = new jdbcconnect();
		Statement st = jd.connect();

		String sql = "insert into company (company_name,company_address,company_number,company_type) values ('" + company.getCompany_Name() + "','"
				+ company.getCompany_Address() + "'," + company.getCompany_Contact_No() + ",'" + company.getType()+ "')";
		try {
			int check = st.executeUpdate(sql);
			System.out.println("check: " + check);
			if (check > 0) {
				RequestDispatcher res=getServletContext().getRequestDispatcher("/Select.jsp");
				res.forward(request, response);		
			}
		} catch (SQLException e) {
			System.out.println("Error while inserting data :" + e);
			String error=e.toString();
			if(error.contains("Duplicate"))
					{
					//out.print("Company Id Alredy Present");
					request.setAttribute("present","Company Id Alredy Present");
					request.setAttribute("comp", company);
					RequestDispatcher res=getServletContext().getRequestDispatcher("/CreateCompany.jsp");
					res.forward(request, response);				
					}else {					
						out.println("Error " + e);
					}
		}
	}
}
