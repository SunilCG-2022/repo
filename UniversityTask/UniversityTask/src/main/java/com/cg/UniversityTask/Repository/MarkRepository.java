package com.cg.UniversityTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.UniversityTask.model.Marks;

public interface MarkRepository extends JpaRepository<Marks, Long> {

}
