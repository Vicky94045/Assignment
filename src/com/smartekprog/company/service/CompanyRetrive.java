package com.smartekprog.company.service;

import java.io.IOException;
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

@WebServlet("/CompanyRetrive")
public class CompanyRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In");

		PrintWriter out = response.getWriter();
		Company co;
		List<Company> clist = new ArrayList<Company>();
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		String sql = "select * from company";
		JsonArray jsonArray = new JsonArray();
		Gson gson=new Gson();
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				co = new Company();
				co.setCompany_id(rs.getLong("Company_id"));
				co.setCompany_Name(rs.getString("Company_Name"));
				co.setCompany_Address(rs.getString("Company_Address"));
				co.setCompany_Contact_No(rs.getString("Company_number"));
				co.setType(rs.getString("company_type"));
				//System.out.println(co.toString());
				clist.add(co);
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
}
