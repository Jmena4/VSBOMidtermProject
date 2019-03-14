package com.skilldistillery.tudorjpa.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.tudorjpa.data.TutDAOUser;
import com.skilldistillery.tudorjpa.entities.User;

@Controller
public class AdminController {
	
	@Autowired
	TutDAOUser userDAO;
	
//	@Autowired 
//	propDAO;
	
	
	@RequestMapping(path="admin.do", method = RequestMethod.GET)
	public ModelAndView getAdminPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User)session.getAttribute("user");
		List<User> allUsers = userDAO.findAllActiveUsers();
	
		mv.addObject("user", user);
		mv.addObject("allUsers", allUsers);
		mv.setViewName("WEB-INF/Admin.jsp");
		return mv;
	}
	
	@RequestMapping(path="deactivateuser.do", method = RequestMethod.POST)
	public String deactivateUser(@RequestParam(value="id")String id  ) {
		User user = userDAO.findUserById(Integer.parseInt(id));
		user.setIsActive(false);
		userDAO.updateUser(Integer.parseInt(id), user);
		
		return "redirect:admin.do";
		
	}

}








