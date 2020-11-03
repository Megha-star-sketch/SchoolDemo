package com.school.School.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.School.Model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{
}
