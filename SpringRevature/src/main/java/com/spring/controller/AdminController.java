package com.spring.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.DAO.AdminDAO;
import com.spring.DAO.StudentDAO;
import com.spring.domain.Admin;
import com.spring.domain.Student;

@Controller
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	StudentDAO studentDAO;
	@RequestMapping(value="/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping(value="/signup")
	public ModelAndView signup() {
		return new ModelAndView("signup");
	}
	@RequestMapping(value="/check")
	public ModelAndView check(@ModelAttribute("admin") Admin admin) {
		Admin aa = adminDAO.checkUserPresent(admin);
		ModelAndView model = null;
		if(aa!=null) {
			List<Student> studentList = studentDAO.getList(); 
			model = new ModelAndView("welcome");
			model.addObject("studentList",studentList);
		}
		else {
			model = new ModelAndView("index");
			model.addObject("error", "Username or Password is incorrect!");
		}
		return model;
	}
	@RequestMapping(value="/add")
	public ModelAndView signup(@ModelAttribute("admin") Admin admin) {
		ModelAndView model = null;
		adminDAO.insert(admin);
		model = new ModelAndView("index");
		return model;
	}
	@RequestMapping(value="/edit/{name}")
	public ModelAndView editPage(@PathVariable String name) {
		Student student = studentDAO.getStudentByName(name);
		ModelAndView model = new ModelAndView("edit");
		model.addObject("student", student);
		return model;
	}
	@RequestMapping(value="/editDetails",method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("edit") Student edit) {
		studentDAO.update(edit);
		ModelAndView model = null;
		List<Student> updatedList = studentDAO.getList();
			model = new ModelAndView("welcome");
			model.addObject("studentList",updatedList);
		return model;
	}
	@RequestMapping(value="insert")
	public ModelAndView insert() {
		return new ModelAndView("insert");
	}
	@RequestMapping(value="addStudent")
	public ModelAndView insertValues(@ModelAttribute("insert") Student insert) {
		studentDAO.insert(insert);
		ModelAndView model = null;
		List<Student> updatedList = studentDAO.getList();
		model = new ModelAndView("welcome");
		model.addObject("studentList", updatedList);
		return model;
	}
	
	@RequestMapping(value="/delete/{name}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable String name) {
		studentDAO.delete(name);
		ModelAndView model = null;
		List<Student> updatedList = studentDAO.getList();
		model = new ModelAndView("welcome");
		model.addObject("studentList", updatedList);
		return model;
	}
	
	@RequestMapping(value="mark")
	public ModelAndView attendance() {
		/*LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusYears(2);
		 
		long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);
		          
		List<LocalDate> listOfDates1 = Stream.iterate(startDate, date -> date.plusDays(1))
		                                    .limit(numOfDays)
		                                    .collect(Collectors.toList());*/
		ModelAndView mv = null;
		mv = new ModelAndView("attendance");
		List<Student> studentList = studentDAO.getAttendanceList();
		mv.addObject("studentList",studentList);
	    return mv;
	}
	
	@RequestMapping(value="present")
	public ModelAndView markAttendance(@ModelAttribute("student")Student student) {
		if(student.getD1()=="present") {
			student.setD1("present");
		}
		else {
			student.setD1("absent");
		}
		Integer count = studentDAO.attendanceUpdate(student);
		System.out.println(count);
		ModelAndView mv = null;
		if(count>0) {
			mv = new ModelAndView("final");
		}
		
		return mv;
	}
}
