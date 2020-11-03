package com.school.School.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.School.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
