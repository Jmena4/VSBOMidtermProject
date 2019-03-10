package com.skilldistillery.tudorjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.tudorjpa.data.TutDAO;

@Controller
public class TutadvisorController {

	@Autowired
	private TutDAO tutDAO;
 
//	*************PLACE HOLDER FOR ACTUAL CONTROLLER**************
//	@RequestMapping(path = { "/", "home.do" }, method = RequestMethod.GET)
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {

//		model.addAttribute("addTudors", tutDAO.findALL());

		return "WEB-INF/landing.jsp";
	}

}
