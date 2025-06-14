package com.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.schoolmanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
