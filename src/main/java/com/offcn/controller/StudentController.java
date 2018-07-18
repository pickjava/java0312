package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.ScoreResult;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/getAllStudent")
	@ResponseBody
	public List<Student> getAllStudent(){
	
		List<Student> list = studentService.getAllStudent();
		return list;	
	}
	
	@RequestMapping("/getAllStudentPie")
	@ResponseBody
	public List<ScoreResult> getAllStudentPie(){
		List<ScoreResult> resultList = new ArrayList<ScoreResult>();
		List<Student> student = studentService.getAllStudent();
		for(Student list:student){
			ScoreResult result = new ScoreResult();
			result.setName(list.getSname());
			result.setValue(list.getScore());
			resultList.add(result);
		}
		
		return resultList;
	}
}
