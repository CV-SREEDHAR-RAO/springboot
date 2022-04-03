package com.sprotyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Logincontroller {
	
	//Home page 
		@RequestMapping({"/index","/"})
		public String home(Model model) {
				return "index";
		}
		
		//Admin Login page 
		@RequestMapping("/adminlogin")
		public String adminlogin(Model model) {
				return "adminlogin";
		}
		
		//Admin Page
		@RequestMapping("/admin")
		public String admin(Model model) {
				return "admin";
		}
		

}
