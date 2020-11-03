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

import com.school.School.Service.ClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.school.School.Model.Class;

@RestController
@RequestMapping("/Class")
@Api(value="Megha", tags= {"Class Data"})
public class ClassController {
	@Autowired
	ClassService service;
	
	@GetMapping("/GetAll")
	@ApiOperation(value="GetAllClass")
	public List<Class> getAllUser()
	{
		return service.getAll();
	}
	@PostMapping("/CreateUser")
	public Class create(@RequestBody Class clas)
	{
		return service.createUser(clas);
	}
	@GetMapping("/Users/{id}")
	public Class getUserById(@PathVariable long id)
	{
		return service.getById(id);
	}
	@DeleteMapping("/DeleteAll")
	public Class deleteAll(@RequestBody Class clas)
	{
		return service.deleteAll(clas);
	}
	@DeleteMapping("/Delete/{id}")
	public void deleteUserById(@PathVariable long id)
	{
		service.deleteById(id);
	}
}
