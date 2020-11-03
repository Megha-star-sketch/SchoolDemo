package com.school.School.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.School.Model.Class;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long>{
		Class findByName(String name);

}
