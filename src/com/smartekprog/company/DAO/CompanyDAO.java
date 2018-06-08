package com.smartekprog.company.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smartekprog.company.model.Company;
import com.smartekprog.connect.jdbcconnect;

public class CompanyDAO {
	
	public List<Company> getAllCompany()
	{
		jdbcconnect con = new jdbcconnect();
		Statement st = con.connect();
		List<Company> clist = new ArrayList<Company>();
		Company co;
		String sql = "select * from company";
		
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				co = new Company();
				co.setCompany_id(rs.getLong("Company_id"));
				co.setCompany_Name(rs.getString("Company_Name"));
				co.setCompany_Address(rs.getString("Company_Address"));
				co.setCompany_Contact_No(rs.getString("Company_number"));
				co.setType(rs.getString("company_type"));				
				clist.add(co);				
			}
		} catch (SQLException e) {			
			System.out.println("Error : " + e);
		}
		return clist;
	}
	
	
	
	public boolean deletecomp(int company_id) {
		
		String sql="delete from company where company_id="+company_id;
		jdbcconnect con=new jdbcconnect();
		Statement st=con.connect();
		try {
			int error=st.executeUpdate(sql);
			System.out.println(error);
			if(error==1)
			{
				return true;
			}else if(error==0)
			{	
				return false;
			}
		}catch (SQLIntegrityConstraintViolationException em) {
			System.out.println("Record deleted");			
		}
		catch (SQLException e) {
			System.out.println("Record not found");			
		}
		return false;
	}
	
	
	public boolean CheckComp(String cname) {
		jdbcconnect con1 = new jdbcconnect();
		Statement st = con1.connect();
		System.out.println("cname="+cname);
		String sql = "Select * from Company where company_name=\""+cname+"\"";
		int count = 0;
		Company co = new Company();
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {			
				count++;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		if(count==1)
		{
		return true;	
		}else {
			return false;
		}
	}
	
	
	public int getCompID(String cname) {
		jdbcconnect con1 = new jdbcconnect();
		Statement st = con1.connect();
		System.out.println("cname="+cname);
		String sql = "Select company_id from Company where company_name=\"" +cname+"\"";		
		Company co = new Company();
		ResultSet rs;
		int cid = 0;
		try {
			rs = st.executeQuery(sql);
			while (rs.next()) {				
				cid=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Error :"+e);
		}
		return cid;
	}

}
