package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.StudentTask;


public interface StudentTaskService {
	List<StudentTask> getAllStudents();
	
	StudentTask saveStudent(StudentTask student);
	
	StudentTask getStudentById(Long id);
	
	StudentTask updateStudent(StudentTask student);
	
	void deleteStudentById(Long id);

	List<StudentTask> listAll(String email);
	public List<StudentTask> getByKeyword(String email);
	
}
