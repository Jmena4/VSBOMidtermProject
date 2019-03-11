package com.skilldistillery.tudorjpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutAdvisorClient;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class SkillsController {

	@Autowired
	private TutAdvisorClient taclient;

//	@RequestMapping(path = "studentSkill.do", method = RequestMethod.GET)
//	public ModelAndView findTutorMatches() {
//		ModelAndView mv = new ModelAndView();
//		Map<Integer, List<User>> student = new HashMap<Integer, List<User>>();
//
//		student = taclient.findAllStudentSuggestion();
//		mv.setViewName("WEB-INF/landing.jsp");
//		System.out.println("###########");
//		System.out.println(student.keySet() + " " + student.size());
//		return mv;
//	}
	@RequestMapping(path = "studentSkill.do", method = RequestMethod.GET)
	public ModelAndView findTutorMatches() {
		ModelAndView mv = new ModelAndView();
		Map<Integer, List<User>> teacher = new HashMap<Integer, List<User>>();

		teacher = taclient.findAllTeacherSuggestion();
		mv.setViewName("WEB-INF/landing.jsp");
		System.out.println("###########");
		System.out.println(teacher.keySet() + " " + teacher.size());
		return mv;
	}
}
