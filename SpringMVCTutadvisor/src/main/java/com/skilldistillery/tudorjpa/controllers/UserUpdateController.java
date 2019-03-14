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
import com.skilldistillery.tudorjpa.entities.SkillName;
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



	@RequestMapping(path = "updateTeachableSkills.do", method = RequestMethod.POST)
	public String updateUsersTeachableSkills(@RequestParam(value = "teachableSkillsUpdate") String[] teachableFromForm,
			@RequestParam(value = "level") String[] level, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<TeachableSkill> current = user.getTeachableSkills();
		List<TeachableSkill> newSkills = new ArrayList<TeachableSkill>();
		if (teachableFromForm != null) {

			for (int i = 0; i < teachableFromForm.length; i++) {
				TeachableSkill ls = skillDAO.findTeachableSkillById(Integer.parseInt((teachableFromForm[i].trim())));

				ls.setSkillLevel(skillDAO.findSkillLevelById(Integer.parseInt((level[i]))));
				skillDAO.updateTeachableSkill(ls.getId(), ls);
				newSkills.add(ls);
			}

			for (TeachableSkill teachableSkill : current) {
				if (!newSkills.contains(teachableSkill)) {
					skillDAO.updateTeachableToInactive(teachableSkill);
				}
			}
		}
		return "redirect:profile.do";
	}

	
	
	@RequestMapping(path = "addToTeachableSkills.do", method = RequestMethod.POST)
	public String addToTeachableSkills(@RequestParam(value = "skillToAdd") String[] skillToAdd,
			@RequestParam(value = "level") String[] level, HttpSession session) {
		User user = (User) session.getAttribute("user");
		for (int i = 0; i < skillToAdd.length; i++) {
			TeachableSkill ts = new TeachableSkill();
			ts.setActive(true);
			ts.setSkillLevel(skillDAO.findSkillLevelById(Integer.parseInt(level[i])));
			System.out.println(ts.getSkillLevel().getName());
			ts.setSkillName(skillDAO.findSkillNameById(Integer.parseInt(skillToAdd[i])));
			ts.setUser(user);
			skillDAO.createTeachableSkill(ts);
		}

		return "redirect:profile.do";
	}

	@RequestMapping(path = "updateLearnableSkills.do", method = RequestMethod.POST)
	public String updateLearnableSkills(@RequestParam(value = "learnableSkillsUpdate") String[] learnableFromForm,
			@RequestParam(value = "level") String[] level, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<LearnableSkill> current = user.getLearnableSkills();
		List<LearnableSkill> newSkills = new ArrayList<LearnableSkill>();
		if (learnableFromForm != null) {

			for (int i = 0; i < learnableFromForm.length; i++) {
				LearnableSkill ls = skillDAO.findLearnableSkillById(Integer.parseInt((learnableFromForm[i].trim())));

				ls.setSkillLevel(skillDAO.findSkillLevelById(Integer.parseInt((level[i]))));
				skillDAO.updateLearnableSkill(ls.getId(), ls);
				newSkills.add(ls);
			}

			for (LearnableSkill learnableSkill : current) {
				if (!newSkills.contains(learnableSkill)) {
					skillDAO.updateLearnableToInactive(learnableSkill);
				}
			}
		}
		return "redirect:profile.do";
	}
	
		
		@RequestMapping(path = "addToLearnableSkills.do", method = RequestMethod.POST)
	public String addToLearnableSkills(@RequestParam(value = "skillToAdd") String[] skillToAdd,
			@RequestParam(value = "level") String[] level, HttpSession session) {
		User user = (User) session.getAttribute("user");
		for (int i = 0; i < skillToAdd.length; i++) {
			LearnableSkill ls = new LearnableSkill();
			ls.setIsActive(true);;
			ls.setSkillLevel(skillDAO.findSkillLevelById(Integer.parseInt(level[i])));
			System.out.println(ls.getSkillLevel().getName());
			ls.setSkillName(skillDAO.findSkillNameById(Integer.parseInt(skillToAdd[i])));
			ls.setUser(user);
			skillDAO.createLearnableSkill(ls);
		}

		return "redirect:profile.do";
	}
}