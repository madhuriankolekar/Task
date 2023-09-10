package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.StudentTask;



public interface StudentTaskRepository extends JpaRepository<StudentTask, Long>{
	@Query("SELECT p FROM StudentTask p WHERE CONCAT(p.taskname) LIKE %?1%")
	public List<StudentTask> search(String taskname);
}
