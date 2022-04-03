package com.sprotyshoes.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.engine.jdbc.env.spi.AnsiSqlKeywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sprotyshoes.model.Productcat;
import com.sprotyshoes.model.Userorder;
import com.sprotyshoes.model.Userreg;
import com.sprotyshoes.repository.Orderrepository;
import com.sprotyshoes.repository.Productrepository;
import com.sprotyshoes.repository.Userrepository;

@RestController
public class Usercontroller {
	
	@Autowired
	private Userrepository userrep;
	
	@Autowired
	private Orderrepository orderrep;
	
	@Autowired
	private Productrepository prodrep;
	
/*
 * User LOGIN controls 
 * 
 */
	
	
	//Product categorization 
		@GetMapping("/productcat")
		public ModelAndView productcat() {
			ModelAndView mav=new ModelAndView("productcat");
				Productcat prodcat=new Productcat();
				mav.addObject("productcat", prodcat);
				return mav;
			}
		
	//saving of categorized product by Admin
		@PostMapping("/category")
		public String catassign(@ModelAttribute ("productcat") Productcat productcat) {
		prodrep.save(productcat);
			return "Product Categorized successfully";
		}
	
				
	//Admin view of registered users
	@GetMapping("/userdisplay" )
	public ModelAndView showusers() {
		ModelAndView mav=new ModelAndView("userdisplay");
		List<Userreg> list= (List<Userreg>) userrep.findAll();
		mav.addObject("userreg", list);
		return mav;
	}
	
	//search by user by Admin
	@GetMapping("/search")
	public ModelAndView findusers(String keyword) {
		ModelAndView find=new ModelAndView("find");
		List<Userreg> list= userrep.findByKeyword(keyword);
		find.addObject("userreg", list);
		return find;
	}
	
	//New user registration form
		@GetMapping("/newuser")
		public ModelAndView newuser() {
			ModelAndView mav=new ModelAndView("newuser");
			Userreg user=new Userreg();
			mav.addObject("userreg", user);
			return mav;
		}
		
		//sign up by the new user
		@PostMapping("/signup")
		public String saveuser(@ModelAttribute ("userreg") Userreg userreg) {
			userrep.save(userreg);
			return "Successfully Registered";
		}
		
		//new order form
		@GetMapping("/neworder")
		public ModelAndView neworder() {
			ModelAndView mav=new ModelAndView("neworder");
			Userorder neworder=new Userorder();
			mav.addObject("userorder",neworder);
			return mav;
		}
		
		//Place an order by User
		@PostMapping("/saveorder")
		public String saveorder(@ModelAttribute ("userorder") Userorder userorder) {
		orderrep.save(userorder);
			return "Product ordered successfully";
		}
		
		//view the user orders by Admin
				@GetMapping("/userorder" )
				public ModelAndView showorders() {
					ModelAndView mav=new ModelAndView("purreports");
					List<Userorder> list= orderrep.findAll();
					mav.addObject("userorder", list);
					return mav;
				}
		
		
		//Filter by Admin by Category/date
		@GetMapping("/filterby")
		public ModelAndView filter(String keyword) {
			ModelAndView filter=new ModelAndView("filter");
			List<Userorder> filter1= orderrep.findbykeyword(keyword);
			filter.addObject("userorder", filter1);
			return filter;
			
		}
		
}
	