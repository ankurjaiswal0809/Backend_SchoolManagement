package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoolmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUserName(String userName);

}
