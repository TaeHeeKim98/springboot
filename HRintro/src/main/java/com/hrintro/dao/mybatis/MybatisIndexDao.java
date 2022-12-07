package com.hrintro.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrintro.dao.IndexDao;
import com.hrintro.entity.StudentList;

@Repository
public class MybatisIndexDao implements IndexDao{
	
	private IndexDao mapper;
	
	@Autowired
	public MybatisIndexDao(SqlSession session) {
		mapper = session.getMapper(IndexDao.class);
	}
	
	@Override
	public List<StudentList> getName() {
		return mapper.getName();
	}

	@Override
	public List<StudentList> getSerName(String name) {
		// TODO Auto-generated method stub
		return mapper.getSerName(name);
	}
	
	@Override
	public List<StudentList> getList(int no) {
		// TODO Auto-generated method stub
		return mapper.getList(no);
	}

	@Override
	public boolean setinfo(int no, String name, String education, String address) {
		// TODO Auto-generated method stub
		return mapper.setinfo(no, name, education, address);
	}

	@Override
	public boolean addinfo(String name, String education, String address) {
		// TODO Auto-generated method stub
		return mapper.addinfo(name, education, address);
	}

	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return mapper.delete(no);
	}

}
