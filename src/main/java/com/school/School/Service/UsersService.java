package com.school.School.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.School.Model.Student;
import com.school.School.Model.Users;
import com.school.School.Repository.UsersRepo;

@Service
public class UsersService {
	@Autowired
	UsersRepo repo;
	
	
	public List<Users> getAll()
	{
		return repo.findAll();
	}
	public Users createUser(Users user)
	{

		return repo.save(user);
	}
	
	public Users getById(long id)
	{
		Optional<Users> user=repo.findById(id);
		if(!user.isPresent()) throw new UserNotFoundException("id : "+id);
		return user.get();
	}
	public Users deleteAll(Users user)
	{
		repo.deleteAll();
		return user;
	}
	public void deleteById(long id)
	{
		 repo.deleteById(id);
	}
}
