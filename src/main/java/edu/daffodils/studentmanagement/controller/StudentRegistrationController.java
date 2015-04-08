package edu.daffodils.studentmanagement.controller;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/students")
	public ModelAndView showStudents() {
		ModelAndView mv = new ModelAndView("showallstudent");
		List<Student> studentList = studentManager.readAllStudents();		
		mv.addObject("students", studentList);
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}