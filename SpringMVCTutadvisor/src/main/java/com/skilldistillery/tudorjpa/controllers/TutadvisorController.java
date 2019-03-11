package com.skilldistillery.tudorjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutDAO;

@Controller
public class TutadvisorController {

	@Autowired
	private TutDAO tutDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {

//		model.addAttribute("addTudors", tutDAO.findALL());

		return "WEB-INF/landing.jsp";
	}

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView homeDo() {
		ModelAndView mv = new ModelAndView();

//		TODO: create method to get list of learnable suggestions and
//		list of teachable suggestions and add them to the model

		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "switch_cards.do", method = RequestMethod.GET)
	public ModelAndView switchCardsDo(String type) {
		ModelAndView mv = new ModelAndView();

		if (type.equals("1")) {

//		TODO: create method to get list of learnable suggestions and
//		list of teachable suggestions and add them to the model
		} else if (type.equals("2")) {

//		TODO: create method to get list of pending proposals and add it to the model
		}

		else if (type.equals("3")) {

//		TODO: create method to get list of proposals not pending and add it to the model
		}

		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}
	
	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
	public ModelAndView profileDo() {
		ModelAndView mv = new ModelAndView();
		
//		TODO: create method to get the user, address, teachable & learnable skills
		
		mv.setViewName("WEB-INF/profile.jsp");
		return mv;
	}
	
	@RequestMapping(path = "modify_profile.do", method = RequestMethod.POST)
	public ModelAndView modifyProfileDo(String first, String last, String email,
			String phone, String url, String uname, String password, String street,
			String street2, String city, String state, String zip,
			String learnableSkills, String teachableSkills) {
		ModelAndView mv = new ModelAndView();
		
//		TODO: create method to update the user, address, teachable & learnable skills
		
		mv.setViewName("WEB-INF/profile.jsp");
		return mv;
	}

	@RequestMapping(path = "logout.do", method = RequestMethod.POST)
	public ModelAndView logoutDo() {
		ModelAndView mv = new ModelAndView();

//		TODO create method to terminate the user session

		mv.setViewName("WEB-INF/landing.jsp");
		return mv;
	}

}
