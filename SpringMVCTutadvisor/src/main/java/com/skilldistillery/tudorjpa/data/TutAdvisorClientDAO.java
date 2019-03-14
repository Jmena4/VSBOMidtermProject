package com.skilldistillery.tudorjpa.data;

import java.util.List;
import java.util.Map;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

public interface TutAdvisorClientDAO {

//	Find all Pending Proposal 
	public List<Proposal> findAllPendingProposal();

//	Find all history other than Pending Proposals
	public List<Proposal> findAllProposalHistory();

//	Find all Suggestions for each student and teacher 
	public Map<Integer, List<User>> findAllStudentSuggestion();

	public Map<Integer, List<User>> findAllTutorSuggestion();

	public Proposal SuggestionBySessionInformation(int id, Proposal managedSuggestion);

	public SkillLevel findSkillLevelById(int id);

	public TeachableSkill findTeachableSkillById(int id);
	
	public LearnableSkill findLearnableSkillById(int id);
	
	public User findTeacherUserById(int id);
	
	public User findStudentUserById(int id);
}
