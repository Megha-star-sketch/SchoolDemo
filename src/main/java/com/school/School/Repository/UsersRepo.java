package com.school.School.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.School.Model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long>{

	Users findByEmail(String email);

}
