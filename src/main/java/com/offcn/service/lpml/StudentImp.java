package com.offcn.service.lpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.StudentDao;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;

@Service
public class StudentImp implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudent() {
		List<Student> student = studentDao.getAllStudent();
		return student;
	}

}
