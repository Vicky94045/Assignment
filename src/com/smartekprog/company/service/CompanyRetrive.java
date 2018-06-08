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
import com.smartekprog.company.DAO.CompanyDAO;
import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/CompanyRetrive")
public class CompanyRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In");
		PrintWriter out = response.getWriter();		
		List<Company> clist = new ArrayList<Company>();
		CompanyDAO cdao=new CompanyDAO();		
		JsonArray jsonArray = new JsonArray();
		clist=cdao.getAllCompany();
		Gson gson=new Gson();					
		request.setAttribute("List", clist);			
		response.setContentType("application/json");
		String data=gson.toJson(clist);		
		response.getWriter().write(data);		
	}
}
