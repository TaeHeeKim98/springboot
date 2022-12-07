package com.hrintro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrintro.entity.StudentList;
import com.hrintro.service.IndexService;

@Controller
public class HomeController {
	
	@Autowired
	private IndexService indexService;
	
	@GetMapping("/")
	public String index(Model model, String name) {
		
		if(name == "" || name == null) {
			List<StudentList> list = indexService.getName();
			
			model.addAttribute("list", list);
			model.addAttribute("name", name);
		}else {
			List<StudentList> list = indexService.getSerName(name);
			
			model.addAttribute("list", list);
			model.addAttribute("name", name);
		}
		
		
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/name")
	public List<StudentList> name(int no){
		List<StudentList> getList = indexService.getList(no);
		
		return getList;
	}
	
	@ResponseBody
	@PostMapping("/edit")
	public String edit(int edit_no, String edit_name, String edit_education, String edit_address){
		
		String msg = "<script>alert('수정에 실패하였습니다.'); history.go(-1);</script>";
		
		boolean setinfo = indexService.setinfo(edit_no, edit_name, edit_education, edit_address);
		
		if(setinfo) {
			msg ="<script>alert('수정에 성공하였습니다.'); location.href='/';</script>";
		}
		
		return msg;
	}
	
	@ResponseBody
	@PostMapping("/add")
	public String edit(String add_name, String add_education, String add_address){
		
		String msg = "<script>alert('등록에 실패하였습니다.'); history.go(-1);</script>";
		
		boolean addinfo = indexService.addinfo(add_name, add_education, add_address);
		
		if(addinfo) {
			msg ="<script>alert('등록에 성공하였습니다.'); location.href='/';</script>";
		}
		
		return msg;
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public boolean delete(int no){
		return indexService.delete(no);
	}
	
}
