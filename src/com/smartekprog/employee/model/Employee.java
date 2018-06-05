package com.smartekprog.employee.model;

import java.sql.Date;

public class Employee {

	private int EmpNo;
	private String First_Name;
	private String Last_Name;
	private int Age;
	private String mailId;
	private String Address;
	private Date Birthdate;
	private int Salary;
	private String Gender;
	private String Mobile_No;
	private Date Hire_date;
	private int Company_id;
	private String Company_Name;

	/*
	 * 
	 * getter and setters
	 * 
	 */

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getMobile_No() {
		return Mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}

	public Date getHire_date() {
		return Hire_date;
	}

	public void setHire_date(Date hire_date) {
		Hire_date = hire_date;
	}

	public int getCompany_id() {
		return Company_id;
	}

	public void setCompany_id(int company_id) {
		Company_id = company_id;
	}

	public Employee(int empNo, String first_Name, String last_Name, int age, String mailId, String address,
			Date birthdate, int salary, String gender, String mobile_No, Date hire_date, int company_id,String Company_Name) {
		super();
		EmpNo = empNo;
		First_Name = first_Name;
		Last_Name = last_Name;
		Age = age;
		this.mailId = mailId;
		Address = address;
		Birthdate = birthdate;
		Salary = salary;
		Gender = gender;
		Mobile_No = mobile_No;
		Hire_date = hire_date;
		Company_id = company_id;
		this.Company_Name=Company_Name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [EmpNo=" + EmpNo + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Age=" + Age
				+ ", mailId=" + mailId + ", Address=" + Address + ", Birthdate=" + Birthdate + ", Salary=" + Salary
				+ ", Gender=" + Gender + ", Mobile_No=" + Mobile_No + ", Hire_date=" + Hire_date + ", Company_id="
				+ Company_id +"Company Name="+Company_Name+"]";
	}

}
