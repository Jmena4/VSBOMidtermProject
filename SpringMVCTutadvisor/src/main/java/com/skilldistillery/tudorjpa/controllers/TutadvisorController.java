package com.skilldistillery.tudorjpa.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.skilldistillery.tudorjpa.data.TutDAO;
import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.data.TutDaoSkills;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class TutadvisorController {


	@Autowired
	private TutDAO tutDAO;
	@Autowired
	private TutDAOUser tutUser;
	@Autowired
	private TutDaoSkills tutSkills;

//	*************PLACE HOLDER FOR ACTUAL CONTROLLER**************
//	@RequestMapping(path = { "/", "home.do" }, method = RequestMethod.GET)

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {

//		model.addAttribute("addTudors", tutDAO.findALL());

		return "WEB-INF/landing.jsp";
	}

//	mock mapping to see the profile page:
//	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
//	public ModelAndView mockProfile(HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		User user = tutUser.findUserById(2);
//		session.setAttribute("user", user);
//		List<TeachableSkill> allTeachableSkills = tutSkills.findAllTeachableSkills();
//		List<LearnableSkill> allLearnableSkills = tutSkills.findAllLearnableSkills();
//
//		mv.setViewName("WEB-INF/profile.jsp");
//		mv.addObject("user", user);
//		mv.addObject("allLearnableSkills", allLearnableSkills);
//		mv.addObject("allTeachableSkills", allTeachableSkills);
//		return mv;
//	}

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

//	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
//	public ModelAndView profileDo() {
//		ModelAndView mv = new ModelAndView();
//		
//		TODO: create method to get the user, address, teachable & learnable skills
//		
//		mv.setViewName("WEB-INF/profile.jsp");
//		return mv;
//	}

	@RequestMapping(path = "modify_profile.do", method = RequestMethod.GET)

	public ModelAndView modifyProfilePage(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/edit_profile.jsp");
		return null;
	}

	@RequestMapping(path = "modify_profile.do", method = RequestMethod.POST)
	public ModelAndView modifyProfileDo(String first, String last, String email, String phone, String url, String uname,
			String password, String street, String street2, String city, String state, String zip) {
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
