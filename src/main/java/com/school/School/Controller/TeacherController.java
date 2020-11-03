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

import com.school.School.Model.Teacher;
import com.school.School.Service.TeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Teacher")
@Api(value="Megha", tags= {"Teacher Data"})
public class TeacherController {
	@Autowired
	private TeacherService service;
	
	@GetMapping("/GetAll")
	@ApiOperation(value="GetAllTeacher")
	public List<Teacher> getAllUser()
	{
		return service.getAll();
	}
	@PostMapping("/CreateUser")
	public Teacher create(@RequestBody Teacher teacher)
	{
		return service.createUser(teacher);
	}
	@GetMapping("/Users/{id}")
	public Teacher getUserById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@DeleteMapping("/DeleteAll")
	public Teacher deleteAll(@RequestBody Teacher teacher)
	{
		return service.deleteAll(teacher);
	}
	@DeleteMapping("/Delete/{id}")
	public void deleteUserById(@PathVariable long id)
	{
		service.deleteById(id);
	}
}
