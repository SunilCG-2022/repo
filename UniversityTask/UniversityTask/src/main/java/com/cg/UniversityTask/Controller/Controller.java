package com.cg.UniversityTask.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.UniversityTask.Repository.UserRepository;
import com.cg.UniversityTask.model.Role;
import com.cg.UniversityTask.model.User;
import com.cg.UniversityTask.service.UserService;


@RestController
public class Controller {
 
    @Autowired
    private UserService service;
    
    private UserRepository userRepository;
         
    @PostMapping("/register")
    public String processRegister(User user) {
        service.registerDefaultUser(user);
         
        return "register_success";
    }  
    
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
    
    @GetMapping("/users/{id}")
    
    	public String retrieveUser(@PathVariable long id) {
    		Optional<User> user = userRepository.findById(id);
    		return "users";
    }
    
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }
    
    
}
