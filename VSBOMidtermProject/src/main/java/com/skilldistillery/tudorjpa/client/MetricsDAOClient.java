package com.skilldistillery.tudorjpa.client;

import com.skilldistillery.tudorjpa.data.TutDAOMetricsImpl;

public class MetricsDAOClient {

	public static void main(String[] args) {
		TutDAOMetricsImpl dao = new TutDAOMetricsImpl();
		System.out.println("Count of active Tutuors: "+ dao.findActiveTutorCount());
		System.out.println();
		
		System.out.println("Count of active sturedents: "+dao.findActiveStudentCount());
		System.out.println();
		
		System.out.println("Count of total teachable skills: "+dao.findTeachableSkillCount());
		System.out.println();
		
		System.out.println("Count of total learnable skills: "+dao.findLearnableSkillCount());
		System.out.println();
	}

}
