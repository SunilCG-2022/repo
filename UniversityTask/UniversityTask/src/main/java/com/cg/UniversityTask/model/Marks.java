package com.cg.UniversityTask.model;


import jakarta.persistence.*;


@Entity
@Table(name = "marks")
public class Marks {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	     
	    @Column(nullable = false, length = 20)
	    private String mark;

}
