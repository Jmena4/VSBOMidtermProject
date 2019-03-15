package com.skilldistillery.tudorjpa.controllers;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.DisplayLearnable;
import com.skilldistillery.tudorjpa.data.DisplayTeachable;
import com.skilldistillery.tudorjpa.data.NewUserAndAddressDTO;
import com.skilldistillery.tudorjpa.data.TutAdvisorClient;
import com.skilldistillery.tudorjpa.data.TutDAO;
import com.skilldistillery.tudorjpa.data.TutDAOAddress;
import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.data.TutDaoSkills;
import com.skilldistillery.tudorjpa.entities.Address;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
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
	@Autowired TutadvisorController tacon;

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
		System.out.println(user.getFirstName());
//		HashSet<TeachableSkill> allTeachableSkills = tutSkills.findAllTeachableSkills();
//		HashSet<LearnableSkill> allLearnableSkills = tutSkills.findAllLearnableSkills();
		HashSet<SkillName> allSkillNames = tutSkills.findAllSkillNames();
		HashSet<TeachableSkill> usersTeachableSkills = tutSkills.findTeachableSkillsByUserId(user.getId());
		HashSet<LearnableSkill> usersLaernableSkills = tutSkills.findLearnableableSkillsByUserId(user.getId());
		

		mv.setViewName("WEB-INF/profile.jsp");
		mv.addObject("user", user);
//		mv.addObject("allLearnableSkills", allLearnableSkills);
//		mv.addObject("allTeachableSkills", allTeachableSkills);
		mv.addObject("allSkillNames", allSkillNames);
		mv.addObject("usersLaernableSkills", usersLaernableSkills);
		mv.addObject("usersTeachableSkills", usersTeachableSkills);

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
	public ModelAndView switchCardsDo(HttpSession session, String type) {
		ModelAndView mv = new ModelAndView();
		User user = (User)session.getAttribute("user");

		if (type.equals("1")) {
			List<DisplayTeachable> learnablelist = null;
			List<DisplayLearnable> teachablelist = null;
			String result = null;
				mv.setViewName("WEB-INF/home.jsp");
				learnablelist = tac.getLearnableMatches(session);
				teachablelist = tac.getTeachableMatches(session);
				mv.addObject("learnablelist", learnablelist);
				mv.addObject("teachablelist", teachablelist);
		} else if (type.equals("2")) {
			Boolean history = true;
			mv.addObject("history", history);
			List<DisplayTeachable> learnableHistoryList = null;
			List<DisplayLearnable> teachableHistoryList = null;
			learnableHistoryList = tac.getLearnableHistory(user.getId());
			teachableHistoryList = tac.getTeachableHistory(user.getId());
			mv.addObject("learnable_history_list", learnableHistoryList);
			mv.addObject("teachable_history_list", teachableHistoryList);
			mv.setViewName("WEB-INF/home.jsp");
		}

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
	public ModelAndView suggestionPage(HttpSession session, String skill_level, String skill_id, String teacher_user, String student_user, String learnable_id, String teachable_id, String is_history) {
		ModelAndView mv = new ModelAndView();
		SkillLevel sl = tac.findSkillLevelById(Integer.parseInt(skill_level));
		mv.addObject("skillLevel", sl);
		
		SkillName sn = tac.findSkillNameById(Integer.parseInt(skill_id));
		mv.addObject("skillName", sn);
		
		
		User tu = tac.findTeacherUserById(Integer.parseInt(teacher_user));
		mv.addObject("teacherUser", tu);
		
		User su = tac.findStudentUserById(Integer.parseInt(student_user));
		mv.addObject("studentUser", su);
		int ls = Integer.parseInt(learnable_id);

//		System.out.println("skill level: " + skill_level);
//		System.out.println("skill ID: " + skill_id);
//		System.out.println("teacher: " + teacher_user);
//		System.out.println("student: " + student_user);
//		System.out.println("learnable ID: " + learnable_id);
//		System.out.println("teachable ID: " + teachable_id);		
		
		if(is_history !=null && !(is_history.equals("true"))) {
		tac.createProposalFromSession(skill_level, skill_id, teacher_user, student_user, learnable_id, teachable_id);
		}
		mv.setViewName("WEB-INF/suggestionPage.jsp");
		return mv;
	}

}
