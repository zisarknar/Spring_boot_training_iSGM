package com.isgm.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.isgm.spring.entities.User;
import com.isgm.spring.services.UserService;

import javassist.expr.NewArray;

@Controller
public class MainController {

	@Autowired
	UserService mService;
	
	@GetMapping("/")
	public String getAllUsers(Model model) {
		List<User> users = mService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/{id}")
	public String getUserById(@PathVariable("id") int id, Model model) {
		User user = mService.getUserById(id);
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/add")
	public String addNewUser(Model model) {
		model.addAttribute("newUser", new User());
		return "new";
	}
	
}
