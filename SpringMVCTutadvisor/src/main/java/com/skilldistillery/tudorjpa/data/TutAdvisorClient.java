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

	public List<DisplayTeachable> getLearnableMatches(HttpSession session) {
		user = (User) (session.getAttribute("user"));
		List<LearnableSkill> myLearnableSkills = null;
		List<TeachableSkill> matches = null;
		List<DisplayTeachable> learnableList = new ArrayList();
		String url = null;
		int lsid = 0;
		String query = "SELECT l FROM LearnableSkill l WHERE l.user.id = :id";
		String query2 = "SELECT t from TeachableSkill t where t.skillName = :skillName and t.skillLevel.id > :level";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		myLearnableSkills = em.createQuery(query, LearnableSkill.class)
				.setParameter("id", user.getId())
				.getResultList();
		for (LearnableSkill learnableSkill : myLearnableSkills) {
			lsid = learnableSkill.getId();
			matches = em.createQuery(query2, TeachableSkill.class)
					.setParameter("skillName", learnableSkill.getSkillName())
					.setParameter("level", learnableSkill.getSkillLevel().getId())
					.getResultList();
			for (TeachableSkill teachableSkill : matches) {
				learnableList.add(new DisplayTeachable(teachableSkill, lsid));
			}
		}
		for (DisplayTeachable displayTeachable : learnableList) {
			em.createQuery(query3, String.class)
					.setParameter("id", displayTeachable.getTeachableSkill().getUser().getId())
					.getSingleResult();
			displayTeachable.setUrl(url);
		}
		return learnableList;
	}

	public List<DisplayLearnable> getTeachableMatches(HttpSession session) {
		user = (User) (session.getAttribute("user"));
		List<TeachableSkill> myTeachableSkills = null;
		List<LearnableSkill> matches = null;
		List<DisplayLearnable> teachableList = new ArrayList();
		String url = null;
		int tsid = 0;
		String query = "SELECT t FROM TeachableSkill t WHERE t.user.id = :id";
		String query2 = "SELECT l from LearnableSkill l where l.skillName = :skillName and l.skillLevel.id < :level";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		myTeachableSkills = em.createQuery(query, TeachableSkill.class)
				.setParameter("id", user.getId())
				.getResultList();

		for (TeachableSkill teachableSkill : myTeachableSkills) {
			tsid = teachableSkill.getId();
			matches = em.createQuery(query2, LearnableSkill.class)
					.setParameter("skillName", teachableSkill.getSkillName())
					.setParameter("level", teachableSkill.getSkillLevel().getId())
					.getResultList();
			for (LearnableSkill learnableSkill : matches) {
				teachableList.add(new DisplayLearnable(learnableSkill, tsid));
			}
		}

		for (DisplayLearnable displayLearnable : teachableList) {
			em.createQuery(query3, String.class)
					.setParameter("id", displayLearnable.getLearnableSkill().getUser().getId())
					.getSingleResult();
			displayLearnable.setUrl(url);
		}

		return teachableList;
	}

//		public List<DisplayTeachable> getLearnableMatches(HttpSession session) {
//			  user = (User) (session.getAttribute("user"));
//			  List<LearnableSkill> myLearnableSkills = null;
//			  List<TeachableSkill> matches = null;
//			  List<TeachableSkill> learnableList = new ArrayList();
//			  List<DisplayTeachable> displayLearnableList = new ArrayList();
//			  String url = null;
//			  String query = "SELECT l FROM LearnableSkill l WHERE l.user.id = :id";
//			  String query2 = "SELECT t from TeachableSkill t where t.skillName = :skillName and t.skillLevel.id > :level";
//			  String query3 = "SELECT u.pictureURL from User u where u.id = :id";
//			  myLearnableSkills = em.createQuery(query, LearnableSkill.class).setParameter("id", user.getId()).getResultList();
//
//			  for (LearnableSkill learnableSkill : myLearnableSkills) {
//			    matches = em.createQuery(query2, TeachableSkill.class)
//			        .setParameter("skillName", learnableSkill.getSkillName())
//			        .setParameter("level", learnableSkill.getSkillLevel().getId())
//			        .getResultList();
//			    learnableList.addAll(matches);
//			  }
//
//			  for (TeachableSkill teachableSkill : learnableList) {
//			    em.createQuery(query3, String.class).setParameter("id", teachableSkill.getUser().getId()).getSingleResult();
//			    displayLearnableList.add(new DisplayTeachable(teachableSkill, url));
//			  }
//
//			  return displayLearnableList;
//			}
//
//			public List<DisplayLearnable> getTeachableMatches(HttpSession session) {
//			  user = (User) (session.getAttribute("user"));
//			  List<TeachableSkill> myTeachableSkills = null;
//			  List<LearnableSkill> matches = null;
//			  List<LearnableSkill> teachableList = new ArrayList();
//			  List<DisplayLearnable> displayTeachableList = new ArrayList();
//			  String url = null;
//			  String query = "SELECT t FROM TeachableSkill t WHERE t.user.id = :id";
//			  String query2 = "SELECT l from LearnableSkill l where l.skillName = :skillName and l.skillLevel.id < :level";
//			  String query3 = "SELECT u.pictureURL from User u where u.id = :id";
//			  myTeachableSkills = em.createQuery(query, TeachableSkill.class).setParameter("id", user.getId()).getResultList();
//
//			  for (TeachableSkill teachableSkill : myTeachableSkills) {
//			    matches = em.createQuery(query2, LearnableSkill.class)
//			        .setParameter("skillName", teachableSkill.getSkillName())
//			        .setParameter("level", teachableSkill.getSkillLevel().getId())
//			        .getResultList();
//			    teachableList.addAll(matches);
//			  }
//			  for (LearnableSkill learnableSkill : teachableList) {
//			    em.createQuery(query3, String.class).setParameter("id", learnableSkill.getUser().getId()).getSingleResult();
//			    displayTeachableList.add(new DisplayLearnable(learnableSkill, url));
//			  }
//			  return displayTeachableList;
//			}

	@Override
	public Proposal SuggestionBySessionInformation(int id) {
		Proposal managedSuggestion = em.find(Proposal.class, id);
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
		SkillLevel skillLevel = null;
		return skillLevel = em.find(SkillLevel.class, id);
	}

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

	@Override
	public SkillName findSkillNameById(int id) {
		SkillName skillName = null;
		return skillName = em.find(SkillName.class, id);
	}

	@Override
	public Proposal createProposalFromSession(String skill_level, String skill_id, String teacher_user,
			String student_user, String learnable_id, String teachable_id) {
		SkillLevel sl = findSkillLevelById(Integer.parseInt(skill_level));
		int ls = Integer.parseInt(learnable_id);
		int ts = Integer.parseInt(teachable_id);
		SkillName sn = findSkillNameById(Integer.parseInt(skill_id));
		User tu = findTeacherUserById(Integer.parseInt(teacher_user));
		User su = findStudentUserById(Integer.parseInt(student_user));
		String query = "SELECT ts FROM TeachableSkill ts WHERE ts.user.id = :tid";
		List<TeachableSkill> teachableSkills = em.createQuery(query, TeachableSkill.class)
				.setParameter("tid", tu.getId()).getResultList();
		Proposal managedProposal = new Proposal();
		managedProposal.setStudent(su);
		managedProposal.setTeacher(tu);
		managedProposal.setLearnableId(ls);
		managedProposal.setTeachableId(ts);
		em.persist(managedProposal);
		em.flush();
		return managedProposal;
	}

	public List<DisplayTeachable> getLearnableHistory(int userId) {
		List<Proposal> learnables = new ArrayList();
		List<TeachableSkill> matches = new ArrayList();
		List<DisplayTeachable> learnableHistoryList = new ArrayList();
		int lsid = 0;
		String url = "";
		String query = "SELECT p FROM Proposal p WHERE p.student.id = :id";
		String query2 = "SELECT t FROM TeachableSkill t WHERE t.id = :id";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		learnables = em.createQuery(query, Proposal.class)
				.setParameter("id", userId)
				.getResultList();
		for (Proposal proposal : learnables) {
			lsid = proposal.getLearnableId();
			matches = em.createQuery(query2, TeachableSkill.class)
					.setParameter("id", proposal.getTeachableId())
					.getResultList();
				for (TeachableSkill teachableSkill : matches) {
					learnableHistoryList.add(new DisplayTeachable(teachableSkill, url, lsid));
				}
		}
		for (DisplayTeachable displayTeachable : learnableHistoryList) {
			url = em.createQuery(query3, String.class)
					.setParameter("id", displayTeachable.getTeachableSkill().getUser().getId())
					.getSingleResult();
					displayTeachable.setUrl(url);		}
		return learnableHistoryList;
	}

	public List<DisplayLearnable> getTeachableHistory(int userId) {
		List<Proposal> teachables = new ArrayList();
		List<LearnableSkill> matches = new ArrayList();
		List<DisplayLearnable> teachableHistoryList = new ArrayList();
		int tsid = 0;
		String url = "";
		String query = "SELECT p FROM Proposal p WHERE p.teacher.id = :id";
		String query2 = "SELECT l FROM LearnableSkill l WHERE l.id = :id";
		String query3 = "SELECT u.pictureURL from User u where u.id = :id";
		teachables = em.createQuery(query, Proposal.class)
				.setParameter("id", userId)
				.getResultList();
		for (Proposal proposal : teachables) {
			tsid = proposal.getTeachableId();
			matches = em.createQuery(query2, LearnableSkill.class)
					.setParameter("id", proposal.getLearnableId())
					.getResultList();
				for (LearnableSkill learnableSkill : matches) {
					teachableHistoryList.add(new DisplayLearnable(learnableSkill, url, tsid));
				}
		}
		for (DisplayLearnable displayLearnable : teachableHistoryList) {
			url = em.createQuery(query3, String.class)
					.setParameter("id", displayLearnable.getLearnableSkill().getUser().getId())
					.getSingleResult();
					displayLearnable.setUrl(url);		}
		return teachableHistoryList;

	}
}
