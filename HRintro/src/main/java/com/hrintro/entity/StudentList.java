package com.hrintro.entity;

public class StudentList {
	private int no;
	private String name;
	private String education;
	private String address;
	
	public StudentList() {}

	public StudentList(int no, String name, String education, String address) {
		super();
		this.no = no;
		this.name = name;
		this.education = education;
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "List [no=" + no + ", name=" + name + ", education=" + education + ", address=" + address + "]";
	}
	
	
}
