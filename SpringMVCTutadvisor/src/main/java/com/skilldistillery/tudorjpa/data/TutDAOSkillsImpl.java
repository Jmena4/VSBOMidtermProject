package com.skilldistillery.tudorjpa.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;

@Transactional
@Service
public class TutDAOSkillsImpl implements TutDaoSkills {

	@PersistenceContext
	private EntityManager em;

//	***SkillLevel methods***
	@Override
	public List<SkillLevel> findAllSkillLevels() {
		String query = "SELECT sl from SkillLevel sl";
		List<SkillLevel> results = em.createQuery(query, SkillLevel.class).getResultList();

		return results;
	}

	@Override
	public SkillLevel createSkillLevel(SkillLevel skilllevel) {
		em.persist(skilllevel);
		em.flush();

		return skilllevel;
	}

	@Override
	public SkillLevel updateSkillLevel(int id, SkillLevel skilllevel) {
		SkillLevel managed = em.find(SkillLevel.class, id);
		managed.setId(skilllevel.getId());
		managed.setName(skilllevel.getName());
		em.flush();
		return managed;
	}

	@Override
	public SkillLevel findSkillLevelById(int id) {
		SkillLevel result = em.find(SkillLevel.class, id);
		return result;
	}

	@Override
	public boolean deleteSkillLevel(int id) {
		boolean result = false;

		try {
			em.remove(em.find(SkillLevel.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}
//	*** Skill Name methods***

	@Override
	public HashSet<SkillName> findAllSkillNames() {
		String query = "SELECT sn from SkillName sn";
		List<SkillName> answer = em.createQuery(query, SkillName.class).getResultList();
		HashSet<SkillName> results = new HashSet<SkillName>();
		
		for (SkillName learnable : answer) {
			results.add(learnable);
			
		}
		return results;
	}

	@Override
	public SkillName createSkillName(SkillName skillname) {
		em.persist(skillname);
		em.flush();

		return skillname;
	}

	@Override
	public SkillName updateSkillName(int id, SkillName skillname) {
		SkillName managed = em.find(SkillName.class, id);
		managed.setId(skillname.getId());
		managed.setName(skillname.getName());
		em.flush();
		return managed;
	}

	@Override
	public SkillName findSkillNameById(int id) {
		SkillName result = em.find(SkillName.class, id);
		return result;
	}

	@Override
	public boolean deleteSkillName(int id) {
		boolean result = false;

		try {
			em.remove(em.find(SkillName.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

//	***Teachable Skill methods***
	@Override
	public HashSet<TeachableSkill> findAllTeachableSkills() {
		String query = "SELECT ts from TeachableSkill ts";
		List<TeachableSkill> answer = em.createQuery(query, TeachableSkill.class).getResultList();
		HashSet<TeachableSkill> results = new HashSet<TeachableSkill>();
		
		for (TeachableSkill teachableSkill : answer) {
			results.add(teachableSkill);
			
		}

		return results;
	}

	@Override
	public TeachableSkill createTeachableSkill(TeachableSkill teachableSkill) {
		em.persist(teachableSkill);
		
		em.flush();

		return teachableSkill;
	}

	@Override
	public TeachableSkill updateTeachableSkill(int id, TeachableSkill teachableSkill) {
		TeachableSkill managed = em.find(TeachableSkill.class, id);
		managed.setId(teachableSkill.getId());
		managed.setComment(teachableSkill.getComment());
		managed.setSkillName(teachableSkill.getSkillName());
		managed.setSkillLevel(teachableSkill.getSkillLevel());
		managed.setUser(teachableSkill.getUser());
		managed.setActive((teachableSkill.getIsActive()));

		em.flush();
		return managed;

	}

	@Override
	public TeachableSkill updateTeachableToInactive(TeachableSkill teachableSkill) {

		TeachableSkill managed = em.find(TeachableSkill.class, teachableSkill.getId());
		managed.setActive(false);
		em.persist(managed);
		em.flush();
		return managed;

	}

	@Override
	public TeachableSkill findTeachableSkillById(int id) {
		TeachableSkill result = em.find(TeachableSkill.class, id);
		return result;
	}

	@Override
	public HashSet<TeachableSkill> findTeachableSkillsByUserId(int id) {
		String query = "Select ts from TeachableSkill ts where ts.user.id= :userId";
		List<TeachableSkill> answer = em.createQuery(query, TeachableSkill.class)
				.setParameter("userId", id)
				.getResultList();
		HashSet<TeachableSkill> result = new HashSet<TeachableSkill>();
		for (TeachableSkill teachableSkill : answer) {
			result.add(teachableSkill);
		}
		return result;
	}

	@Override
	public HashSet<LearnableSkill> findLearnableableSkillsByUserId(int id) {
		String query = "Select ls from LearnableSkill ls where ls.user.id= :userId";
		List<LearnableSkill> answer = em.createQuery(query, LearnableSkill.class)
				.setParameter("userId", id)
				.getResultList();
		HashSet<LearnableSkill> result = new HashSet<LearnableSkill>();
		for (LearnableSkill learnableSkill : answer) {
			result.add(learnableSkill);
		}
		return result;
	}

	@Override
	public boolean deleteTeachableSkill(int id) {
		boolean result = false;

		try {
			em.remove(em.find(TeachableSkill.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

//	***Learnable Skill methods***
	@Override
	public HashSet<LearnableSkill> findAllLearnableSkills() {
		String query = "SELECT ls from LearnableSkill ls";
		List<LearnableSkill> answer = em.createQuery(query, LearnableSkill.class).getResultList();
		HashSet<LearnableSkill> results = new HashSet<LearnableSkill>();
		
		for (LearnableSkill teachableSkill : answer) {
			results.add(teachableSkill);
			
		}
		return results;
	}

	@Override
	public LearnableSkill createLearnableSkill(LearnableSkill learnableskill) {
		em.persist(learnableskill);
		em.flush();

		return learnableskill;
	}

	@Override
	public LearnableSkill updateLearnableSkill(int id, LearnableSkill learnableskill) {
		LearnableSkill managed = em.find(LearnableSkill.class, id);
		managed.setId(learnableskill.getId());
		managed.setComment(learnableskill.getComment());
		managed.setSkillLevel(learnableskill.getSkillLevel());
		managed.setSkillName(learnableskill.getSkillName());
		managed.setUser(learnableskill.getUser());
		em.flush();
		return managed;

	}

	@Override
	public LearnableSkill findLearnableSkillById(int id) {
		LearnableSkill result = em.find(LearnableSkill.class, id);
		return result;
	}

	@Override
	public boolean deleteLearnableSkill(int id) {
		boolean result = false;

		try {
			em.remove(em.find(LearnableSkill.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

	@Override
	public LearnableSkill updateLearnableToInactive(LearnableSkill learnableSkill) {

		LearnableSkill managed = em.find(LearnableSkill.class, learnableSkill.getId());
		managed.setIsActive(false);
		em.persist(managed);
		em.flush();
		return managed;

	}
}
