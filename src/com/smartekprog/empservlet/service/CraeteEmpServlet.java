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

import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;

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
		// ===================================================Code to find if company
		// present or not

		long cid = Long.parseLong(request.getParameter("cid"));

		jdbcconnect con1 = new jdbcconnect();
		Statement st = con1.connect();

		String sql = "Select * from Company where company_id=" + cid;
		int count = 0;
		Company co = new Company();
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {
				co = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				count++;
			}
		} catch (Exception e) {
			out.println("Error :" + e);
		}

		if (count == 1) {
			// =====================================================
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
			emp.setCompany_id(Integer.parseInt(request.getParameter("cid")));
			emp.setCompany_Name(request.getParameter("cname"));
			System.out.println("Company name= "+emp.getCompany_Name());
			// emp.setBirthdate(new
			// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
			// emp.setHire_date(new
			// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Hiredate")));
			emp.setBirthdate(java.sql.Date.valueOf(request.getParameter("dob")));
			emp.setHire_date(java.sql.Date.valueOf(request.getParameter("Hiredate")));
			jdbcconnect con = new jdbcconnect();
			Connection conn = con.getconnection();
			String sql1 = "insert into employee(Empno,First_Name,Last_Name,Age,Mail_id,Address,Birthdate,Salary,Gender,Mobile_no,Hire_date,Company_name,Company_id)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pst = conn.prepareStatement(sql1);
				pst.setInt(1, emp.getEmpNo());
				pst.setString(2, emp.getFirst_Name());
				pst.setString(3, emp.getLast_Name());
				pst.setInt(4, emp.getAge());
				pst.setString(5, emp.getMailId());
				pst.setString(6, emp.getAddress());
				pst.setDate(7, (java.sql.Date) emp.getBirthdate());
				pst.setInt(8, emp.getSalary());
				pst.setString(9, emp.getGender());
				pst.setString(10, emp.getMobile_No());
				pst.setDate(11, (java.sql.Date) emp.getHire_date());
				pst.setString(12, emp.getCompany_Name());
				pst.setInt(13, emp.getCompany_id());
				
				pst.executeUpdate();				
				out.println("Data Inserted");
				
			} catch (java.sql.SQLIntegrityConstraintViolationException e) {
				out.println("Error in prepare : " + e);
			} catch (SQLException e) {
				System.out.println("Error in prepare: " + e);
				out.println("ERROR in prepare:" + e);
			}
		} else {
			out.print("Company id not present");
		}
	}
}
