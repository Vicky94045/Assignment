package com.smartekprog.empservlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;

@WebServlet("/Checkeeid")
public class Checkeid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Checkeid() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Employee emp = null;
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		int count = 0;
		String sql = "select count(empno) from Employee where empno=" + request.getParameter("eno");
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
				out.println(count);
			}

			if (count == 1) {
				sql = "select * from employee where empno=" + request.getParameter("eno");
				rs = st.executeQuery(sql);
				while(rs.next())
				{
				emp = new Employee();
				emp.setEmpNo(rs.getInt(1));
				emp.setFirst_Name(rs.getString(2));
				emp.setLast_Name(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setMailId(rs.getString(5));
				emp.setAddress(rs.getString(6));
				emp.setBirthdate(rs.getDate(7));
				emp.setSalary(rs.getInt(8));
				emp.setGender(rs.getString(9));
				emp.setMobile_No(rs.getString(10));
				emp.setHire_date(rs.getDate(11));
				emp.setCompany_id(rs.getInt(12));
				}
				HttpSession session = request.getSession();
				session.setAttribute("emp", emp);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Updateempdata.jsp");
				rd.forward(request, response);
			} else {				
				request.setAttribute("Error","Employee Id not found");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateemp.jsp");
				dispatcher.forward(request, response);
			}
			
			System.out.println(count);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}

}
