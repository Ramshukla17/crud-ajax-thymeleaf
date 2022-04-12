package com.ram.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.ram.domain.StudentDomain;
import com.ram.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/addStudent", method=RequestMethod.GET)
	public String getStudent()
	{
		return "index";
	}
	@RequestMapping(value="/saveStudent" , method = RequestMethod.POST)
	public String saveStudent(StudentDomain data, Model model)
	{
		studentService.saveStudent(data);
		model.addAttribute("msg", "Student Redorde Added Successfully !");
		return "index";
	}
	@RequestMapping(value="/viewStudent", method = RequestMethod.GET)
	public List<StudentDomain> viewStudent(
				@RequestParam(defaultValue = "1") Integer pageNo, 
	            @RequestParam(defaultValue = "10") Integer pageSize,
	            @RequestParam(defaultValue = "id") String sortBy,
				Model model)
	{
		List<StudentDomain> student=studentService.viewStudent(1,10,"id");
		model.addAttribute("student", student);
		System.out.println(student);
		return student;
	}
	@RequestMapping(value="/editStudent/{id}",method=RequestMethod.GET)
	public StudentDomain editStudent(@PathVariable long id,@ModelAttribute StudentDomain studentDomain, Model model)
	{
		StudentDomain student=studentService.editStudent(studentDomain);
		model.addAttribute("student", student);
		return student;
	}
	@RequestMapping(value="/updateStudent",method=RequestMethod.POST)
	public RedirectView updateStudent(@ModelAttribute StudentDomain student,Model model,HttpServletRequest request)
	{
		studentService.saveStudent(student);
		RedirectView redirect = new RedirectView();
		redirect.setUrl(request.getContextPath() + "/");
		return redirect;
	}
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.GET)
	public RedirectView deleteStudent(@PathVariable long id,Model model,HttpServletRequest request)
	{
		studentService.deleteStudent(id);
		RedirectView redirect = new RedirectView();
		redirect.setUrl(request.getContextPath() + "/");
		return redirect;
	}
}
