package com.skilldistillery.tudorjpa.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.Proposal;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

@Transactional
@Service
public class TutAdvisorClient implements TutAdvisorClientDAO {
	private User user;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Proposal> findAllPendingProposal() {
		List<Proposal> proposal = null;
		String queryP = "SELECT p FROM Proposal p WHERE p.proposalStatusId = 1"; // Need to write the query statement
		proposal = em.createQuery(queryP, Proposal.class).getResultList();
		return proposal;
	}

	@Override
	public List<Proposal> findAllProposalHistory() {
		List<Proposal> history = null;
		String queryH = "SELECT h FROM Proposal h WHERE h.proposalStatusId != 1"; // Need to write the query statement
																					// the query
																					// statement
		history = em.createQuery(queryH, Proposal.class).getResultList();
		return history;
	}

	@Override
	public Map<Integer, List<User>> findAllTutorSuggestion() {
		List<LearnableSkill> learnableSkills = null;
		String queryS = "SELECT l FROM LearnableSkill l  WHERE l.user.id = 1 ";
		System.out.println("***************"); // For testing purpose
		System.out.println(em); // For testing purpose
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
	public Map<Integer, List<User>> findAllStudentSuggestion() {
		List<TeachableSkill> teachableSkills = null;
		System.out.println("$$$$$$$$$$$$$$");// For testing purpose
		System.out.println(em);// For testing purpose
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

//	public List<TeachableSkill> getLearnableMatches(HttpSession session) {
//		user = (User) (session.getAttribute("user"));
//		List<SkillName> myLearnableSkills = null;
//		List<TeachableSkill> matches = null;
//		List<TeachableSkill> learnableList = new ArrayList();
//		String query = "SELECT l.skillName FROM LearnableSkill l WHERE l.user.id = :id";
//		String query2 = "SELECT t from TeachableSkill t where t.skillName = :skillName";
//		myLearnableSkills = em.createQuery(query, SkillName.class).setParameter("id", user.getId()).getResultList();
//
//		for (SkillName skillName : myLearnableSkills) {
//			matches = em.createQuery(query2, TeachableSkill.class).setParameter("skillName", skillName).getResultList();
//			learnableList.addAll(matches);
//		}
//		return learnableList;
//	}

//public List<LearnableSkill> getTeachableMatches(HttpSession session) {
//	user = (User) (session.getAttribute("user"));
//	List<SkillName> myTeachableSkills = null;
//	List<LearnableSkill> matches = null;
//	List<LearnableSkill> teachableList = new ArrayList();
//	String query = "SELECT t.skillName FROM TeachableSkill t WHERE t.user.id = :id";
//	String query2 = "SELECT l from LearnableSkill l where l.skillName = :skillName";
//	myTeachableSkills = em.createQuery(query, SkillName.class).setParameter("id", user.getId()).getResultList();
//
//	for (SkillName skillName : myTeachableSkills) {
//		matches = em.createQuery(query2, LearnableSkill.class).setParameter("skillName", skillName).getResultList();
//		teachableList.addAll(matches);
//	}
//	return teachableList;
//}

	public List<DisplayTeachable> getLearnableMatches(HttpSession session) {
		user = (User) (session.getAttribute("user"));
		List<SkillName> myLearnableSkills = null;
		List<TeachableSkill> matches = null;
		List<TeachableSkill> learnableList = new ArrayList();
		List<DisplayTeachable> displayLearnableList = new ArrayList();
		String url = null;
		String query = "SELECT l.skillName FROM LearnableSkill l WHERE l.user.id = :id";
		String query2 = "SELECT t from TeachableSkill t where t.skillName = :skillName";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		myLearnableSkills = em.createQuery(query, SkillName.class).setParameter("id", user.getId()).getResultList();

		for (SkillName skillName : myLearnableSkills) {
			matches = em.createQuery(query2, TeachableSkill.class).setParameter("skillName", skillName).getResultList();
			learnableList.addAll(matches);
		}

		for (TeachableSkill teachableSkill : learnableList) {
			em.createQuery(query3, String.class).setParameter("id", teachableSkill.getUser().getId()).getSingleResult();
			displayLearnableList.add(new DisplayTeachable(teachableSkill, url));
		}

		return displayLearnableList;
	}

	public List<DisplayLearnable> getTeachableMatches(HttpSession session) {
		user = (User) (session.getAttribute("user"));
		List<SkillName> myTeachableSkills = null;
		List<LearnableSkill> matches = null;
		List<LearnableSkill> teachableList = new ArrayList();
		List<DisplayLearnable> displayTeachableList = new ArrayList();
		String url = null;
		String query = "SELECT t.skillName FROM TeachableSkill t WHERE t.user.id = :id";
		String query2 = "SELECT l from LearnableSkill l where l.skillName = :skillName";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		myTeachableSkills = em.createQuery(query, SkillName.class).setParameter("id", user.getId()).getResultList();

		for (SkillName skillName : myTeachableSkills) {
			matches = em.createQuery(query2, LearnableSkill.class).setParameter("skillName", skillName).getResultList();
			teachableList.addAll(matches);
		}
		for (LearnableSkill learnableSkill : teachableList) {
			em.createQuery(query3, String.class).setParameter("id", learnableSkill.getUser().getId()).getSingleResult();
			displayTeachableList.add(new DisplayLearnable(learnableSkill, url));
		}
		return displayTeachableList;
	}


	@Override
	public Proposal SuggestionBySessionInformation(int id, Proposal managedSuggestion) {
		managedSuggestion = em.find(Proposal.class, id);
		Proposal proposal2 = new Proposal();
		System.out.println("&&&&&&&&&&&&&&&&&&&");
		managedSuggestion.setTeachableId(proposal2.getTeachableId());
		managedSuggestion.setLearnableId(proposal2.getLearnableId());
		managedSuggestion.setStudent(proposal2.getStudent());
		managedSuggestion.setTeacher(proposal2.getTeacher());
		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);
		sdf.format(managedSuggestion.getDateTimeCreated() + " " + sdf2.format(managedSuggestion.getDateTimeCreated()));
		em.persist(managedSuggestion);
		em.flush();
		return managedSuggestion;
	}

	@Override
	public SkillLevel findSkillLevelById(int id) {

		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public TeachableSkill findTeachableSkillById(int id) {
//
//		SkillLevel skillLevel = null;
////		= em.find(SkillName.class, id);
//		return skillLevel = em.find(SkillLevel.class, id);
//	}
//		SkillLevel skillLevel = null;
//		= em.find(SkillName.class, id);
//		return skillLevel = em.find(SkillLevel.class, id);
//	}
//		SkillLevel skillLevel = null;
//		= em.find(SkillName.class, id);
//		return skillLevel = em.find(SkillLevel.class, id);
//	}
	
	@Override
	public TeachableSkill findTeachableSkillById(int id) {
		TeachableSkill teachableSkill = null;
		return teachableSkill = em.find(TeachableSkill.class, id);
	}

	@Override
	public LearnableSkill findLearnableSkillById(int id) {

		LearnableSkill learnableSkill = null;
		return learnableSkill = em.find(LearnableSkill.class, id);
	}

	@Override
	public User findTeacherUserById(int id) {
		User teacherUser = null;
		return teacherUser = em.find(User.class, id);
	}

	@Override
	public User findStudentUserById(int id) {
		User studentUser = null;
		return studentUser = em.find(User.class, id);
	}

}
