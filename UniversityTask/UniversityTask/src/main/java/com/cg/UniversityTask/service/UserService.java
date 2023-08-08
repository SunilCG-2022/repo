package com.cg.UniversityTask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.UniversityTask.Repository.RoleRepository;
import com.cg.UniversityTask.Repository.UserRepository;
import com.cg.UniversityTask.model.User;
import com.cg.UniversityTask.model.Role;

@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepo;
     
    @Autowired RoleRepository roleRepo;
     
   
     
    public void registerDefaultUser(User user) {
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
 
        userRepo.save(user);
    }
     
    public List<User> listAll() {
        return userRepo.findAll();
    }
    
    public User get(Long id) {
        return userRepo.findById(id).get();
    }
     
    public List<Role> listRoles() {
        return roleRepo.findAll();
    }
}