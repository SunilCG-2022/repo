package com.cg.UniversityTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.UniversityTask.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
