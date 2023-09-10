package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentTask;
import com.example.demo.repo.StudentTaskRepository;


@Service
public class StudentTaskServiceImpl implements StudentTaskService{

	private StudentTaskRepository studentRepository;
	
	public StudentTaskServiceImpl(StudentTaskRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<StudentTask> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public StudentTask saveStudent(StudentTask student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentTask getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public StudentTask updateStudent(StudentTask student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}
	public List<StudentTask> listAll(String email) {
        if (email != null) {
            return studentRepository.search(email);
        }
        return studentRepository.findAll();
    }
	 public List<StudentTask> getByKeyword(String taskname){
		 if (taskname != null) {
	            return studentRepository.search(taskname);
	        }
	        return studentRepository.findAll();
	}
}


