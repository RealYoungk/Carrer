package com.apress.spring.web;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apress.spring.domain.User;
import com.apress.spring.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping(value="/user", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<User> getUser(){
		return repo.findAll();
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", repo.findAll());
		return "index";
	}
}