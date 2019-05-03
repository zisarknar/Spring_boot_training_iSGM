package com.isgm.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.isgm.spring.entities.User;
import com.isgm.spring.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService mService;
	
	
//	Get all users
	@GetMapping("/")
	public String getAllUsers(Model model) {
		List<User> users = mService.getAllUsers();
		model.addAttribute("users", users);
		return "index";
	}
	
//	Get User By Id
	@GetMapping("/{id}")
	public String getUserById(@PathVariable("id") int id, Model model) {
		User user = mService.getUserById(id);
		model.addAttribute("user", user);
		return "index";
	}
	
//	Add new User
	@GetMapping("/add")
	public String addNewUser(Model model) {
		model.addAttribute("newUser", new User());
		return "new";
	}
	
	@PostMapping("/add")
	public String addNewUserPost(@ModelAttribute("user") @Valid User user) {
		mService.addNewUser(user);
		return "redirect:/";
	}
	
// Update User
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("oldUser", mService.getUserById(id));
        return "update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("user") @Valid User user, @PathVariable("id") int id) {
    	User oldUser = mService.getUserById(id);
    	oldUser.setAddress(user.getAddress());
    	oldUser.setName(user.getName());
    	oldUser.setPhone(user.getPhone());
    	mService.update(oldUser);
        return "redirect:/";
    }
	
//	Delete User
	@GetMapping("/remove/{id}")
	public String remoteUser(@PathVariable("id") int id) {
		mService.removeBtId(id);
		return "redirect:/?success";
	}
	
}
