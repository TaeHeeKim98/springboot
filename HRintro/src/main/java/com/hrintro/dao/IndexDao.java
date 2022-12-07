package com.hrintro.dao;

import java.util.List;

import com.hrintro.entity.StudentList;

public interface IndexDao {
	
	List<StudentList> getName();

	List<StudentList> getSerName(String name);
	
	List<StudentList> getList(int no);
	
	public boolean setinfo(int no, String name, String education, String address);

	boolean addinfo(String name, String education, String address);

	boolean delete(int no);
	
}
