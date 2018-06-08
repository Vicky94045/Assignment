package com.smartekprog.empservlet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smartekprog.connect.jdbcconnect;
import com.smartekprog.employee.model.Employee;

public class EmployeeDAO {

	public List<Employee> getAllEmployee(){
		List<Employee> list=new ArrayList<>();
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		String sql = "select * from Employee";
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
		Employee emp=new Employee();
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
			list.add(emp);		
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean delete(int eid) {
		jdbcconnect con=new jdbcconnect();
		Statement st=con.connect();
		String sql="delete from employee where empno="+eid;
		try {
			int i=st.executeUpdate(sql);
			if(i==1) {			
				return true;
			}else {			
				return false;
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean create(Employee emp) {
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
			System.out.println(emp.getCompany_Name());
			System.out.println(emp.getCompany_id());
			pst.setString(12, emp.getCompany_Name());
			pst.setInt(13, emp.getCompany_id());
			
			pst.executeUpdate();		
		return true;
	}catch (java.sql.SQLIntegrityConstraintViolationException e) {		
		String error=e.toString();
		if(error.contains("Duplicate"))
		{
		System.out.println("Duplicate record");		
		}else {					
			System.out.println(e);
		}		
	}		
		catch (Exception e) {
		System.out.println("error "+ e);
		return false;
	}
		return false;
	}
	
	public void update() {
		
		
	}
	
	
	
}
