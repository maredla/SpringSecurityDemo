package com.sanjay.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanjay
 *
 * Controller class containing all the REST endpoints
 */
@RestController
public class HelloController {
	
	@RequestMapping("/user")
	public String getUser() {
			return "I am the only the user!";
	}
	
	@RequestMapping("/admin")
	public String getAddress() {
		return "I'm the BOSS!!";
	}
	
	@RequestMapping("/role")
	public String getRole() {
		return "CEO";
	}
	
	@RequestMapping("/wiki")
	public String getWiki() {
		return "All can see it. Its a Wiki!!";
	}
}
