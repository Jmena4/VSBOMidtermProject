package com.skilldistillery.tudorjpa.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skilldistillery.tudorjpa.data.TutAdvisorClient;
import com.skilldistillery.tudorjpa.entities.User;

public class TutAdvisorClientTest {

	public static void main(String[] args) {

		TutAdvisorClient tac = new TutAdvisorClient();
		Map<Integer, List<User>> student = new HashMap<Integer, List<User>>();

		student = tac.findAllStudentSuggestion();
		System.out.println(student);
	}

}