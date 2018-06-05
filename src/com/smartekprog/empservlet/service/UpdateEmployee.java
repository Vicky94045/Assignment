package com.smartekprog.empservlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		emp.setCompany_id(Integer.parseInt(request.getParameter("cid")));
		// emp.setBirthdate(new
		// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")));
		// emp.setHire_date(new
		// SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Hiredate")));
		emp.setBirthdate(java.sql.Date.valueOf(request.getParameter("dob")));
		emp.setHire_date(java.sql.Date.valueOf(request.getParameter("Hiredate")));
		String sql = "update employee SET Empno="+emp.getEmpNo()+",First_Name='" + emp.getFirst_Name()
				+ "',Last_Name='" + emp.getLast_Name() + "',Age=" + emp.getAge() + ",Mail_id='" + emp.getMailId()
				+ "',Address='" + emp.getAddress() + "',Birthdate='" + emp.getBirthdate() + "',Salary=" + emp.getSalary()
				+ ",Gender='" + emp.getGender() + "',Mobile_no='" + emp.getMobile_No() + "',Hire_Date='"
				+ emp.getHire_date() + "',Company_id='" + emp.getCompany_id() + "' where Empno=" + emp.getEmpNo() + ";";
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		try {
			int i = st.executeUpdate(sql);
			if (i == 1) {
				out.println("Record updated..");
			} else {
				out.print("Record not updated");
			}
		}catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Company id not present");
		} catch (SQLException e) {
			System.out.println("error =" + e);
			e.printStackTrace();
		}
	}

}
