package com.smartekprog.company.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

@WebServlet("/CompanyUpdate")
public class CompanyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long cid = Long.parseLong(request.getParameter("cid"));
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
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
			if (count == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("company", co);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateforcid.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("Error","Company Id not found");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/update.jsp");
				dispatcher.forward(request, response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
