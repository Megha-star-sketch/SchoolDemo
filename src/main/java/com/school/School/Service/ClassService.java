package com.school.School.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.School.Repository.ClassRepo;
import com.school.School.Model.Class;
@Service
public class ClassService {
	@Autowired
	private ClassRepo repo;
	public List<Class> getAll()
	{
		return repo.findAll();
	}
	public Class createUser(Class clas)
	{	
		return repo.save(clas);
	}
	
	public Class getById(long id)
	{
		Optional<Class> user=repo.findById(id);
		if(!user.isPresent()) throw new UserNotFoundException("id : "+id);
		return user.get();
	}
	public Class deleteAll(Class clas)
	{
		repo.deleteAll();
		return clas;
	}
	public void deleteById(long id)
	{
		 repo.deleteById(id);
	}
}
