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
import com.smartekprog.empservlet.DAO.EmployeeDAO;

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
		JsonArray jsonArray = new JsonArray();
		Gson gson=new Gson();
		EmployeeDAO edao=new EmployeeDAO();
		clist=edao.getAllEmployee();	
			request.setAttribute("List", clist);			
			response.setContentType("application/json");
			String data=gson.toJson(clist);		
			response.getWriter().write(data);			
	} 	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
