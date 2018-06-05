package com.smartekprog.empservlet.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;

/**
 * Servlet implementation class EmployeeRetrive
 */
@WebServlet("/EmployeeRetrive")
public class EmployeeRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeRetrive() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		Employee emp = null;
		System.out.println("Inside emp retrive");
		List<Employee> clist = new ArrayList<Employee>();
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		String sql = "select * from Employee";
		JsonArray jsonArray = new JsonArray();
		Gson gson=new Gson();
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				emp=new Employee();
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
				emp.setCompany_Name(rs.getString(12));
				emp.setCompany_id(rs.getInt(13));
			//	System.out.println(emp.toString());
				clist.add(emp);
				
			}			
			
			request.setAttribute("List", clist);			
			response.setContentType("application/json");
			String data=gson.toJson(clist);		
			response.getWriter().write(data);			
		} catch (SQLException e) {
			out.println("Error : " + e);
			System.out.println("Error : " + e);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
