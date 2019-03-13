package com.skilldistillery.tudorjpa.data;

import java.util.List;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;



public interface TutDaoSkills {

	
//	Skill Level CRUD
	
	public List<SkillLevel> findAllSkillLevels();
	public SkillLevel createSkillLevel(SkillLevel skilllevel);
	public SkillLevel updateSkillLevel(int id, SkillLevel skilllevel);
	public SkillLevel findSkillLevelById(int id);
	public boolean deleteSkillLevel(int id);
	
//	Skill name CRUD
	public List<SkillName> findAllSkillNames();
	public SkillName createSkillName(SkillName skillname);
	public SkillName updateSkillName(int id, SkillName skillname);
	public SkillName findSkillNameById(int id);
	public boolean deleteSkillName(int id);
	
//	Teachable Skill CRUD
	public List<TeachableSkill> findAllTeachableSkills();
	public TeachableSkill createTeachableSkill(TeachableSkill teachableSkill);
	public TeachableSkill updateTeachableSkill(int id, TeachableSkill teachableSkill);
	public TeachableSkill findTeachableSkillById(int id);
	TeachableSkill updateTeachableToInactive(TeachableSkill teachableSkill);
	public boolean deleteTeachableSkill(int id);
	List<TeachableSkill> findTeachableSkillsByUserId(int id);
	
//	Learnable Skill
	public List<LearnableSkill> findAllLearnableSkills();
	public LearnableSkill createLearnableSkill(LearnableSkill learnableskill);
	public LearnableSkill updateLearnableSkill(int id, LearnableSkill learnableskill);
	public LearnableSkill findLearnableSkillById(int id);
	public boolean deleteLearnableSkill(int id);
	LearnableSkill updateLearnableToInactive(LearnableSkill learnableSkill);
	List<LearnableSkill> findLearnableableSkillsByUserId(int id);
}
