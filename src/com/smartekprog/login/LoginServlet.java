package com.smartekprog.login;

import java.io.IOException;
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

import com.smartekprog.connect.jdbcconnect;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un=request.getParameter("uname");
		String pw=request.getParameter("password");
		
		jdbcconnect jd = new jdbcconnect();
		Statement st = jd.connect();
		String sql = "select * from users";
		int count=0;
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(un.equals(rs.getString(1)) && pw.equals(rs.getString(2))) {
				count=1;	
				}
			
			}
			
			if(count==1)
			{
				RequestDispatcher dicp=getServletContext().getRequestDispatcher("/Select.jsp");
				dicp.forward(request, response);
			}
			else {
				request.setAttribute("Fial","Invalid User Name or password");
				RequestDispatcher dicp=getServletContext().getRequestDispatcher("/Index.jsp");			
				dicp.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
