package com.school.School.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.School.Model.Class;
import com.school.School.Model.Teacher;
import com.school.School.Model.Users;
import com.school.School.Repository.ClassRepo;
import com.school.School.Repository.TeacherRepo;
import com.school.School.Repository.UsersRepo;
@Service
@Transactional
public class TeacherService {
	@Autowired
	TeacherRepo repo;
	@Autowired
	ClassRepo clsrepo;
	@Autowired
	UsersRepo userrepo;
	
	public List<Teacher> getAll()
	{
		return repo.findAll();
	}
	public Teacher createUser(Teacher teacher)
	{
		try
		{
			// id teacher is already exist 
//			String teach=(Teacher) repo.findByClass_teach(teacher);
//			if(teach!=null)
//			{
//				System.out.println("teach Obj"+teach);
//				teacher.setClass_teach(teach);
//			}
			//For Class if class exist
			Class cls=clsrepo.findByName(((Class) teacher.getClasss()).getName());
			if(cls!=null)
			{
				System.out.println("Cls Obj "+cls);
				teacher.setClasss((List<Class>) cls);
			}
			//For User if user exist
			Users userObj=userrepo.findByEmail(teacher.getUser().getEmail());
			if(userObj != null)
			{
				System.out.println("User Object" + userObj);
				teacher.setUser(userObj);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return repo.save(teacher);
	}
	
	public Teacher getById(long id)
	{
		Optional<Teacher> user=repo.findById(id);
		if(!user.isPresent()) throw new UserNotFoundException("id : "+id);
		return user.get();
	}
	public Teacher deleteAll(Teacher teacher)
	{
		repo.deleteAll();
		return teacher;
	}
	public void deleteById(long id)
	{
		 repo.deleteById(id);
	}
}
