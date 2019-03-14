package com.skilldistillery.tudorjpa.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.skilldistillery.tudorjpa.data.DisplayLearnable;
import com.skilldistillery.tudorjpa.data.DisplayTeachable;
import com.skilldistillery.tudorjpa.data.TutAdvisorClient;

import com.skilldistillery.tudorjpa.data.NewUserAndAddressDTO;
import com.skilldistillery.tudorjpa.data.TutDAO;
import com.skilldistillery.tudorjpa.data.TutDAOAddress;
import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.data.TutDaoSkills;
import com.skilldistillery.tudorjpa.entities.Address;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class TutadvisorController {

	@Autowired
	private TutDAOAddress tutAddress;
	@Autowired
	private TutDAO tutDAO;
	@Autowired
	private TutDAOUser tutUser;
	@Autowired
	private TutDaoSkills tutSkills;
	@Autowired
	private TutAdvisorClient tac;

//	*************PLACE HOLDER FOR ACTUAL CONTROLLER**************
//	@RequestMapping(path = { "/", "home.do" }, method = RequestMethod.GET)

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("newUser", new NewUserAndAddressDTO());

//		model.addAttribute("addTudors", tutDAO.findALL());

		return "WEB-INF/landing.jsp";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView loginDo(String username, String password, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<DisplayTeachable> learnablelist = null;
		List<DisplayLearnable> teachablelist = null;
		User user = tutUser.validateUsernameAndPassword(username, password);
		String result = null;
		if (user != null) {
			mv.setViewName("WEB-INF/home.jsp");
			session.setAttribute("user", user);

			learnablelist = tac.getLearnableMatches(session);
			teachablelist = tac.getTeachableMatches(session);
			mv.addObject("learnablelist", learnablelist);
			mv.addObject("teachablelist", teachablelist);
		}
		else {

			mv.setViewName("WEB-INF/landing.jsp");
			result = "Invalid username or password";
			mv.addObject("result", result);
		}
		return mv;
	}

//	public ModelAndView Login(@Valid User user, HttpSession session) {
//	  ModelAndView mv = new ModelAndView();
//	  LocalDateTime lt = LocalDateTime.now();
//	  session.setAttribute("loginTime", lt);
//	  mv.setViewName("WEB-INF/home.jsp");
//	  return mv;
//	}

//	mapping to see the profile page:
	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
	public ModelAndView goToProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		List<TeachableSkill> allTeachableSkills = tutSkills.findAllTeachableSkills();
		List<LearnableSkill> allLearnableSkills = tutSkills.findAllLearnableSkills();
		List<SkillName> allSkillNames = tutSkills.findAllSkillNames();

		mv.setViewName("WEB-INF/profile.jsp");
		mv.addObject("user", user);
		mv.addObject("allLearnableSkills", allLearnableSkills);
		mv.addObject("allTeachableSkills", allTeachableSkills);
		mv.addObject("allSkillNames", allSkillNames);


		return mv;
	}

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView homeDo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<DisplayTeachable> learnablelist = null;
		List<DisplayLearnable> teachablelist = null;
		User user = (User)(session.getAttribute("user"));
		String result = null;
		if(user != null) {
			mv.setViewName("WEB-INF/home.jsp");
			learnablelist = tac.getLearnableMatches(session);
			teachablelist = tac.getTeachableMatches(session);
			mv.addObject("learnablelist", learnablelist);
			mv.addObject("teachablelist", teachablelist);
		}
		else {
			mv.setViewName("WEB-INF/landing.jsp");
			result = "Invalid username or password";
			mv.addObject("result", result);
		}
		return mv;
	}

	@RequestMapping(path = "switch_cards.do", method = RequestMethod.GET)
	public ModelAndView switchCardsDo(String type) {
		ModelAndView mv = new ModelAndView();

		if (type.equals("1")) {

			List<LearnableSkill> learnable = null;
			List<TeachableSkill> teachable = null;
//		TODO: create method to get list of learnable suggestions and
//		list of teachable suggestions and add them to the model

//		mv.addObject("learnable_list", learnableList);
//		mv.addObject("teachable_list", teachableList);

		} else if (type.equals("2")) {
			List<Proposal> historyList = null;
//		TODO: create method to get list of pending proposals and add it to the model
			mv.addObject("history_list", historyList);
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

	@RequestMapping(path = "register.do", method = RequestMethod.POST)
	public ModelAndView registerPOST(HttpSession session, NewUserAndAddressDTO dto) {
		
		
		Address add = new Address();
		add.setAddress(dto.getStreet());
		add.setCity(dto.getCity());
		add.setPostalCode(dto.getCity());
		add = tutAddress.createAddresses(add);
		
		User user = new User();
		user.setFirstName(dto.getFirstname());
		user.setLastName(dto.getLastname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		user.setPictureURL(dto.getUrl());
		user.setAddressId(add);
		user.setIsActive(true);
		user.setIsAdmin(false);
		
		tutUser.createUser(user);
		session.setAttribute("user", user);
		ModelAndView mv = new ModelAndView();
		boolean reg = true;
		mv.addObject("reg", reg);
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}
	
	@RequestMapping(path = "registration.do", method = RequestMethod.GET)
	public ModelAndView registerRedirect() {
		ModelAndView mv = new ModelAndView();
		boolean reg = true;
		mv.addObject("newUser", new NewUserAndAddressDTO());

		mv.addObject("reg", reg);
		mv.setViewName("WEB-INF/landing.jsp");
		return mv;
	}



	@RequestMapping(path = "logout.do", method = RequestMethod.POST)
	public ModelAndView logoutDo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("WEB-INF/landing.jsp");
		return mv;
	}

	@RequestMapping(path = "suggestionPage.do", method = RequestMethod.POST)
	public ModelAndView suggestionPage(HttpSession session, String skill_level, String skill_id, String teacher_user, String student_user) {
		ModelAndView mv = new ModelAndView();
		System.out.println(skill_level);
		System.out.println(skill_id);
		System.out.println(teacher_user);
		System.out.println(student_user);
		mv.setViewName("WEB-INF/suggestionPage.jsp");
		return mv;
	}

}
