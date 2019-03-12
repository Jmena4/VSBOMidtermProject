package com.skilldistillery.tudorjpa.data;

import java.util.List;
import java.util.Map;

import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.User;

public interface TutAdvisorClientDAO {

//	Find all Pending Proposal 
	public List<Proposal> findAllPendingProposal();

//	Find all history other than Pending Proposals
	public List<Proposal> findAllProposalHistory();

//	Find all Suggestions for each student and teacher 
	public Map<Integer, List<User>> findAllStudentSuggestion();

	public Map<Integer, List<User>> findAllTutorSuggestion();
}
