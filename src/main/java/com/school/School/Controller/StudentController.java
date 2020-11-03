package com.school.School.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.School.Model.Student;
import com.school.School.Service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/Student")
@Api(value="Megha", tags= {"Student Data"})
public class StudentController {
	@Autowired
	StudentService service;
	
	@ApiOperation(value="GetAllStudent")
	@GetMapping("/GetAll")
	public List<Student> getAllUser()
	{
		return service.getAll();
	}
	@PostMapping("/CreateUser")
	public Student create(@RequestBody Student student)
	{
		return service.createUser(student);
	}
	@GetMapping("/Users/{id}")
	public Student getUserById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@DeleteMapping("/DeleteAll")
	public Student deleteAll(@RequestBody Student student)
	{
		return service.deleteAll(student);
	}
	@DeleteMapping("/Delete/{id}")
	public void deleteUserById(@PathVariable long id)
	{
		service.deleteById(id);
	}
}
