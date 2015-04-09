package edu.daffodils.studentmanagement.controller;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.daffodils.studentmanagement.model.Student;
import edu.daffodils.studentmanagement.service.StudentManager;

@Controller
public class StudentRegistrationController {
	String message = "Welcome to Deffodils registartion system!";
	@Autowired
	private StudentManager studentManager;
	Logger logger = Logger.getLogger(StudentRegistrationController.class.getName());	
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Sadh") String name) {
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/secure-students")
	public ModelAndView showStudents() {
		ModelAndView mv = new ModelAndView("showallstudent");
		List<Student> studentList = studentManager.readAllStudents();		
		mv.addObject("students", studentList);
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");
 
	  return model;
 
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied() {
	 
	  ModelAndView model = new ModelAndView();
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken) && (auth != null)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
 
	  model.setViewName("403");
	  return model;
 
	}
	
	
	@RequestMapping({"/", "/welcome**"})
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}