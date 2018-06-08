package com.smartekprog.company.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/CompanyUpdateData")
public class CompanyUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompanyUpdateData() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside Comp update");	
		PrintWriter out = response.getWriter();
		String check=request.getParameter("cid");
		System.out.println(request.getParameter("cname"));
		Company company = new Company(Long.parseLong((request.getParameter("cid"))), request.getParameter("cname"),
				request.getParameter("caddress"), request.getParameter("cnumber"), request.getParameter("ctype"));
		HttpSession session = request.getSession();
		Long cid = (Long) session.getAttribute("company_id");
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		String sql = "update company set Company_Name='" + company.getCompany_Name() + "',Company_Address='"
				+ company.getCompany_Address() + "',Company_number=" + company.getCompany_Contact_No()
				+ ",Company_Type='" + company.getType() + "' where Company_id=" + company.getCompany_id();
		try {
			int error = st.executeUpdate(sql);
			System.out.println("error value if no error is 1 : " + error);			
			if(error==1)
			{
			//out.println("Data updated successfully");
				String data="Record updated";
				response.getWriter().write(data);
			}else {
				//out.println("Data fail to update");
				String data="Record Not updated";
				response.getWriter().write(data);
			}			
		} catch (SQLException e) {
			System.out.println("Exception : " + e);
		}
	}

}
