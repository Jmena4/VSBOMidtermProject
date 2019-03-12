package com.skilldistillery.tudorjpa.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutAdvisorClient;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class SkillsController {

	@Autowired
	private TutAdvisorClient taclient;

	@RequestMapping(path = "studentSkill.do", method = RequestMethod.GET)
	public ModelAndView findStudentMatches() {
		ModelAndView mv = new ModelAndView();
		Map<Integer, List<User>> student = new HashMap<Integer, List<User>>();

		student = taclient.findAllStudentSuggestion();
		mv.setViewName("WEB-INF/landing.jsp");
		System.out.println("###########");
		System.out.println(student.keySet() + " " + student.size());
		return mv;
	}

	@RequestMapping(path = "tutorSkill.do", method = RequestMethod.GET)
	public ModelAndView findTutorMatches() {
		ModelAndView mv = new ModelAndView();
		Map<Integer, List<User>> tutor = new HashMap<Integer, List<User>>();

		tutor = taclient.findAllTutorSuggestion();
		mv.setViewName("WEB-INF/landing.jsp");
		System.out.println("###########");
		System.out.println(tutor.keySet() + " " + tutor.size());
		return mv;
	}

	@RequestMapping(path = "pendingProposal.do", method = RequestMethod.GET)
	public ModelAndView findPendingProposalData() {
		ModelAndView mv = new ModelAndView();
		List<Proposal> proposal = new ArrayList<>();

		proposal = taclient.findAllPendingProposal();
		mv.setViewName("WEB-INF/landing.jsp");
		System.out.println("-----------------");
		System.out.println(proposal.size());
		return mv;
	}

	@RequestMapping(path = "proposalHistory.do", method = RequestMethod.GET)
	public ModelAndView findProposalHistoryData() {
		ModelAndView mv = new ModelAndView();
		List<Proposal> history = new ArrayList<>();

		history = taclient.findAllProposalHistory();
		mv.setViewName("WEB-INF/landing.jsp");
		System.out.println("**************");
		System.out.println(history.size());
		return mv;
	}
}
