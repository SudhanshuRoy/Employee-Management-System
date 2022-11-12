package com.masai.model;

public class Engineer {
	
	private int engid;
	private String engname;
	private String engemail;
	private String engpassword;
	private String category;

	public Engineer() {
		
	}
	

	public Engineer(int engid, String engname, String engemail, String engpassword, String category) {
		super();
		this.engid = engid;
		this.engname = engname;
		this.engemail = engemail;
		this.engpassword = engpassword;
		this.category = category;
	}


	public int getEngid() {
		return engid;
	}

	public void setEngid(int engid) {
		this.engid = engid;
	}

	public String getEngname() {
		return engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public String getEngemail() {
		return engemail;
	}

	public void setEngemail(String engemail) {
		this.engemail = engemail;
	}

	public String getEngpassword() {
		return engpassword;
	}

	public void setEngpassword(String engpassword) {
		this.engpassword = engpassword;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Engineer [engid=" + engid + ", engname=" + engname + ", engemail=" + engemail + ", engpassword="
				+ engpassword + ", category=" + category + "]";
	}

	
	
	

}
