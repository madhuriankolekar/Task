package com.example.demo.controller;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entity.StudentTask;
import com.example.demo.service.StudentTaskService;



@Controller
public class StudentTaskController {
	
	private StudentTaskService studentService;

	public StudentTaskController(StudentTaskService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		StudentTask student = new StudentTask();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") StudentTask student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") StudentTask student,
			Model model) {
		StudentTask existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setEmail(student.getTaskdescription());
		existingStudent.setTaskname(student.getTaskname());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

	@GetMapping("/search/{email}")
	 public String home(StudentTask shop, Model model, @Param("email") String email) {
	  if(email!=null) {
	   List<StudentTask> list = studentService.getByKeyword(email);
	   model.addAttribute("list", list);
	  }else {
	  List<StudentTask> list = studentService.getAllStudents();
	  model.addAttribute("list", list);}
	  return "index";
	 }
}
