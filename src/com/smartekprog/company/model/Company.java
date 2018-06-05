package com.smartekprog.company.model;

public class Company {

	private long Company_id;
	private String Company_Name;
	private String Company_Address;
	private String Company_Contact_No;
	private String Type;

	public long getCompany_id() {
		return Company_id;
	}

	public void setCompany_id(long company_id) {
		Company_id = company_id;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public String getCompany_Address() {
		return Company_Address;
	}

	public void setCompany_Address(String company_Address) {
		Company_Address = company_Address;
	}

	public String getCompany_Contact_No() {
		return Company_Contact_No;
	}

	public void setCompany_Contact_No(String company_Contact_No) {
		Company_Contact_No = company_Contact_No;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Company(long company_id, String company_Name, String company_Address, String company_Contact_No,
			String type) {
		super();
		Company_id = company_id;
		Company_Name = company_Name;
		Company_Address = company_Address;
		Company_Contact_No = company_Contact_No;
		Type = type;
	}

	@Override
	public String toString() {
		return "Company [Company_id=" + Company_id + ", Company_Name=" + Company_Name + ", Company_Address="
				+ Company_Address + ", Company_Contact_No=" + Company_Contact_No + ", Type=" + Type + "]";
	}

	public Company() {

	}

}
