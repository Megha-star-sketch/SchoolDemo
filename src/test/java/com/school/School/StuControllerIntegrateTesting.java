package com.school.School;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.school.School.Controller.StudentController;
import com.school.School.Model.Student;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuControllerIntegrateTesting {
	@Autowired
	private StudentController stu1;
	@Test
	public void givenStuController()
	{
		Student stu=new Student(101L,"First");
		stu1.create(stu);
		
		Student result=stu1.getUserById(101L);
		Assert.assertEquals(stu.getClass_type(),result.getClass_type());
	}
}
