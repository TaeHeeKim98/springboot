package com.hrintro.service;

import java.util.List;

import com.hrintro.entity.StudentList;

public interface IndexService {
	
	//학생정보 가져오기
	public List<StudentList> getName();
	
	public List<StudentList> getSerName(String name);
	
	public List<StudentList> getList(int no);

	public boolean setinfo(int no, String name, String education, String address);

	public boolean addinfo(String name, String education, String address);

	public boolean delete(int no);
	
}
