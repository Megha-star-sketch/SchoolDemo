package com.school.School;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.school.School.Model.Student;
import com.school.School.Repository.StudentRepo;
import static org.assertj.core.api.Assertions.assertThat;
import com.school.School.Service.StudentService;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentUnitTesting {
	@Mock
	private StudentRepo StuRepo;
	@InjectMocks
	private StudentService StuService;
	@Test
	public void WhenFindAll_thenReturnStudent()
	{
				//given
				Student student=new Student();
				student.setClass_type("First");
				student.setAdm_year("2020");
				student.setAdm_number("101");
				List<Student> expectedStudent=Arrays.asList(student);
				doReturn(expectedStudent).when(StuRepo).findAll();			
				//when
				List<Student> actualStudent=StuService.getAll();
				//then
				assertThat(actualStudent).isEqualTo(expectedStudent);
	}
}
