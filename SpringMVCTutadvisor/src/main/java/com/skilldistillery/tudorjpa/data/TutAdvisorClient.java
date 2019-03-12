package com.skilldistillery.tudorjpa.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

@Transactional
@Service
public class TutAdvisorClient implements TutAdvisorClientDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Proposal> findAllProposal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposal> findAllHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, List<User>> findAllStudentSuggestion() {
		List<LearnableSkill> learnableSkills = null;
		String queryS = "SELECT l FROM LearnableSkill l  WHERE l.user.id = 1 ";
		System.out.println("***************");
		System.out.println(em);
		String querySDos = "SELECT t.user FROM TeachableSkill t WHERE t.skillName.id = :teachableSkill";
		learnableSkills = em.createQuery(queryS, LearnableSkill.class).getResultList();
		Map<Integer, List<User>> availableTutors = new HashMap<Integer, List<User>>();
		for (LearnableSkill learnableSkill : learnableSkills) {
			Integer skillNameId = learnableSkill.getSkillName().getId();
			List<User> tutors = new ArrayList<>();

			tutors = em.createQuery(querySDos, User.class).setParameter("teachableSkill", skillNameId).getResultList();
			if (tutors.size() > 0) {
				availableTutors.put(skillNameId, tutors);
			}
//			If no suggestions are found don't add to MAP
			else {

			}
		}
		return availableTutors;
	}

	@Override
	public Map<Integer, List<User>> findAllTeacherSuggestion() {
		List<TeachableSkill> teachableSkills = null;
		System.out.println("$$$$$$$$$$$$$$");
		System.out.println(em);
		String queryT = "SELECT t FROM TeachableSkill t WHERE t.user.id = 3";
		String queryTDos = "SELECT l.user FROM LearnableSkill l WHERE l.skillName.id = :learnableSkill";
		teachableSkills = em.createQuery(queryT, TeachableSkill.class).getResultList();
		Map<Integer, List<User>> availableStudents = new HashMap<Integer, List<User>>();
		for (TeachableSkill teachableSkill : teachableSkills) {
			Integer skillNameId = teachableSkill.getSkillName().getId();
			List<User> students = new ArrayList<>();

			students = em.createQuery(queryTDos, User.class).setParameter("learnableSkill", skillNameId)
					.getResultList();
			if (students.size() > 0) {
				availableStudents.put(skillNameId, students);
			}
//			If no suggestions are found don't add to MAP
			else {

			}
		}

		return availableStudents;
	}

}
