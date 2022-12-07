package com.hrintro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrintro.dao.IndexDao;
import com.hrintro.entity.StudentList;

@Service
public class IndexServiceImp implements IndexService{
	
	@Autowired
	private IndexDao indexDao;
	
	@Override
	public List<StudentList> getName() {
		return indexDao.getName();
	}

	@Override
	public List<StudentList> getSerName(String name) {
		// TODO Auto-generated method stub
		return indexDao.getSerName(name);
	}
	
	@Override
	public List<StudentList> getList(int no) {
		// TODO Auto-generated method stub
		return indexDao.getList(no);
	}

	@Override
	public boolean setinfo(int no, String name, String education, String address) {
		// TODO Auto-generated method stub
		return indexDao.setinfo(no, name, education, address);
	}

	@Override
	public boolean addinfo(String name, String education, String address) {
		// TODO Auto-generated method stub
		return indexDao.addinfo(name, education, address);
	}

	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return indexDao.delete(no);
	}

}
