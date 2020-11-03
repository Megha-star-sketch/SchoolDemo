package com.school.School.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.School.Model.Class;
import com.school.School.Model.Student;
import com.school.School.Model.Users;
import com.school.School.Repository.ClassRepo;
import com.school.School.Repository.StudentRepo;
import com.school.School.Repository.UsersRepo;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepo repo;
	@Autowired
	private ClassRepo classRepo;
	@Autowired
	private UsersRepo userrepo;

	public List<Student> getAll() {
		return repo.findAll();
		
	}

	public Student createUser(Student stu) {
		try {
			//If Class is already exist
			Class classObj = classRepo.findByName(stu.getClasss().getName());
			if (classObj != null) {
				System.out.println("Class Object" + classObj);
				stu.setClasss(classObj);
			}
			//If User is already exist
			Users userObj=userrepo.findByEmail(stu.getUser().getEmail());
			if(userObj != null)
			{
				System.out.println("User Object" + userObj);
				stu.setUser(userObj);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return repo.save(stu);

	}

	public Student getById(long id) {
		Optional<Student> user = repo.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id : " + id);
		return user.get();
	}

	public Student deleteAll(Student stu) {
		repo.deleteAll();
		return stu;
	}

	public void deleteById(long id) {
		repo.deleteById(id);
	}
}
