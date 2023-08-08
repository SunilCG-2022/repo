package com.cg.university.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.university.app.exception.ResourceNotFoundException;
import com.cg.university.app.models.Student;
import com.cg.university.app.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	//Get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return repository.findAll();
	}
	
	//Get students by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) throws ResourceNotFoundException{
		Student student = repository.findById(id).orElseThrow(() 
				->new ResourceNotFoundException("Student not exist with id "+ id));
		return ResponseEntity.ok(student);
	}
	
	//Create a student
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	
	//Update the student
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student	student = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id "+ id));
		student.setFirst_name(studentDetails.getFirst_name());
		student.setLast_name(studentDetails.getLast_name());
		student.setGrade(studentDetails.getGrade());
		
		Student updatedStudent = repository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	//Delete student
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable long id) throws ResourceNotFoundException{
		Student	student = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id "+ id));
		repository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
