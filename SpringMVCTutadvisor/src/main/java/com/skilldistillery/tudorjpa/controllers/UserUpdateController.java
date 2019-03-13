package com.skilldistillery.tudorjpa.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutDAO;
import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.data.TutDaoSkills;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class UserUpdateController {

	@Autowired
	private TutDAO tutDAO;
	@Autowired
	private TutDAOUser tutUser;
	@Autowired
	private TutDaoSkills skillDAO;

	@RequestMapping(path = "profile.do", method = RequestMethod.GET)
	public ModelAndView mockProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = tutUser.findUserById(2);
		mv.addObject("user", user);
		session.setAttribute("user", user);

		List<TeachableSkill> allTeachableSkills = skillDAO.findAllTeachableSkills();
		List<LearnableSkill> allLearnableSkills = skillDAO.findAllLearnableSkills();

		mv.setViewName("WEB-INF/profile.jsp");
		mv.addObject("allLearnableSkills", allLearnableSkills);
		mv.addObject("allTeachableSkills", allTeachableSkills);
		return mv;
	}

	@RequestMapping(path = "updateTeachableSkills.do", method = RequestMethod.POST)
	public String updateUsersTeachableSkills(@RequestParam(value = "teachableSkillsUpdate") String[] teachableFromForm,
			@RequestParam(value = "level") String[] level, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<TeachableSkill> current = user.getTeachableSkills();
		List<TeachableSkill> newSkills = new ArrayList<TeachableSkill>();
		if (teachableFromForm != null) {

			for (int i = 0; i < teachableFromForm.length; i++) {
				TeachableSkill ts = skillDAO.findTeachableSkillById(Integer.parseInt(teachableFromForm[i]));

				ts.setSkillLevel(skillDAO.findSkillLevelById(Integer.parseInt((level[i]))));
				skillDAO.updateTeachableSkill(ts.getId(), ts);
				newSkills.add(ts);
			}

			for (TeachableSkill teachacbleSkill : current) {
				if (!newSkills.contains(teachacbleSkill)) {
					skillDAO.updateTeachableToInactive(teachacbleSkill);
					user.setTeachableSkills(newSkills);
				}
			}
		}
		return "redirect:profile.do";
	}

}
