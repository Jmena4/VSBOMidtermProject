package com.skilldistillery.tudorjpa.Data;

import java.util.List;

import com.skilldistillery.tudorjpa.entities.User;

public interface TutDAOMetrics {
	public Long findActiveTutorCount();
	public Long findActiveStudentCount();
	public Long findTeachableSkillCount();
	public Long findLearnableSkillCount();
}