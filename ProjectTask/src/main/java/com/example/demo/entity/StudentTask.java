package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "studentstask")
@Data
public class StudentTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name" )
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	//@Column(name = "email", nullable=false, unique=true)
	@Column(name = "email")
	private String email;
	@Column(name = "taskdescription")
	private String taskdescription;
	@Column(name = "taskname")
	private String taskname;
}