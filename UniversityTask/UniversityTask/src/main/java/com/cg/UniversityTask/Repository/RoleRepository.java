package com.cg.UniversityTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.UniversityTask.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String string);


}
