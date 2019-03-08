package com.skilldistillery.tudorjpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.tudorjpa.data.TutDAO;

@Controller
public class TutadvisorController {

	@Autowired
	private TutDAO tutDAO;
}
