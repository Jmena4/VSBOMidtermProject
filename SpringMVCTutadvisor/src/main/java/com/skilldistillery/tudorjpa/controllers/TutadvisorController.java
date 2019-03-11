package com.skilldistillery.tudorjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.entities.User;


@Controller
public class TutadvisorController {

//	@Autowired
//	private TutDAO tutDAO;
	
	@Autowired
	private TutDAOUser tutUser;
 
//	*************PLACE HOLDER FOR ACTUAL CONTROLLER**************
//	@RequestMapping(path = { "/", "home.do" }, method = RequestMethod.GET)
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {

//		model.addAttribute("addTudors", tutDAO.findALL());

		return "WEB-INF/landing.jsp";
	}
	
//	mock mapping to see the profile page:
	@RequestMapping(path="profile.do", method = RequestMethod.GET)
	public ModelAndView mockProfile() {
		ModelAndView mv = new ModelAndView();
		User user = tutUser.findUserById(1);

		mv.setViewName("WEB-INF/profile.jsp");
		mv.addObject("user", user);
		return mv;
	}

}
