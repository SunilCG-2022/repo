package com.cg.UniversityTask.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    
   @Column(nullable = false, unique = true, length = 45)
   private String email;
    
   @Column(nullable = false, length = 64)
   private String password;
    
   @Column(name = "name", nullable = false, length = 20)
   private String name;

    
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
   )
   private Set<Role> roles = new HashSet<>();



public User(Long id, String email, String password, String name, Set<Role> roles) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.name = name;
	this.roles = roles;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public Set<Role> getRoles() {
	return roles;
}


public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
   

public void addRole(Role role) {
    this.roles.add(role);
}


@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", name=" + name + ", roles=" + roles + "]";
}

}
