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
import com.school.School.Model.Users;
import com.school.School.Repository.StudentRepo;
import com.school.School.Repository.UsersRepo;
import com.school.School.Service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Users")
@Api(value="Megha", tags= {"Users Data"})
public class UsersController {
	@Autowired
	private UsersService service;
	
	@GetMapping("/GetAll")
	@ApiOperation(value="GetAllUsers")
	public List<Users> getAllUser()
	{
		return service.getAll();
	}
	@PostMapping("/CreateUser")
	public Users create(@RequestBody Users user)
	{	

	//	Student.setUser(repo.save(student.getUser()));

		return service.createUser(user);
	}
	@GetMapping("/Users/{id}")
	public Users getUserById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@DeleteMapping("/DeleteAll")
	public Users deleteAll(@RequestBody Users user)
	{
		return service.deleteAll(user);
	}
	@DeleteMapping("/Delete/{id}")
	public void deleteUserById(@PathVariable long id)
	{
		service.deleteById(id);
	}
}
