package com.skilldistillery.tudorjpa.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;

public class TutDAOSkillsImpl implements TutDaoSkills {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutAdvisor");
	private EntityManager em = emf.createEntityManager();

//	***SkillLevel methods***
	@Override
	public List<SkillLevel> findAllSkillLevels() {
		String query = "SELECT sl from SkillLevel sl";
		List<SkillLevel> results = em.createQuery(query, SkillLevel.class).getResultList();

		return results;
	}

	@Override
	public SkillLevel createSkillLevel(SkillLevel skilllevel) {
		em.getTransaction().begin();
		em.persist(skilllevel);
		em.flush();
		em.getTransaction().commit();

		return skilllevel;
	}

	@Override
	public SkillLevel updateSkillLevel(int id, SkillLevel skilllevel) {
		em.getTransaction().begin();
		SkillLevel managed = em.find(SkillLevel.class, id);
		managed.setId(skilllevel.getId());
		managed.setName(skilllevel.getName());
		em.flush();
		em.getTransaction().commit();
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
		em.getTransaction().begin();

		try {
			em.remove(em.find(SkillLevel.class, id));
			result = true;
		} catch (Exception e) {

		}
		em.getTransaction().commit();

		return result;
	}
//	*** Skill Name methods***

	@Override
	public List<SkillName> findAllSkillNames() {
		String query = "SELECT sn from Skillname sn";
		List<SkillName> results = em.createQuery(query, SkillName.class).getResultList();

		return results;
	}

	@Override
	public SkillName createSkillName(SkillName skillname) {
		em.getTransaction().begin();
		em.persist(skillname);
		em.flush();
		em.getTransaction().commit();

		return skillname;
	}

	@Override
	public SkillName updateSkillName(int id, SkillName skillname) {
		em.getTransaction().begin();
		SkillName managed = em.find(SkillName.class, id);
		managed.setId(skillname.getId());
		managed.setName(skillname.getName());
		em.flush();
		em.getTransaction().commit();
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
		em.getTransaction().begin();

		try {
			em.remove(em.find(SkillName.class, id));
			result = true;
		} catch (Exception e) {

		}
		em.getTransaction().commit();

		return result;
	}

//	***Teachable Skill methods***
	@Override
	public List<TeachableSkill> findAllTeachableSkills() {
		String query = "SELECT sn from Skillname sn";
		List<TeachableSkill> results = em.createQuery(query, TeachableSkill.class).getResultList();

		return results;
	}

	@Override
	public TeachableSkill createTeachableSkill(TeachableSkill teachableSkill) {
		em.getTransaction().begin();
		em.persist(teachableSkill);
		em.flush();
		em.getTransaction().commit();

		return teachableSkill;
	}

	@Override
	public TeachableSkill updateTeachableSkill(int id, TeachableSkill teachableSkill) {
		em.getTransaction().begin();
		TeachableSkill managed = em.find(TeachableSkill.class, id);
		managed.setId(teachableSkill.getId());
		managed.setComment(teachableSkill.getComment());
		managed.setLevel(teachableSkill.getLevel());
		managed.setSkill(teachableSkill.getSkill());
		managed.setUser(teachableSkill.getUser());
		em.flush();
		em.getTransaction().commit();
		return managed;

	}

	@Override
	public TeachableSkill findTeachableSkillById(int id) {
		TeachableSkill result = em.find(TeachableSkill.class, id);
		return result;
	}

	@Override
	public boolean deleteTeachableSkill(int id) {
		boolean result = false;
		em.getTransaction().begin();

		try {
			em.remove(em.find(TeachableSkill.class, id));
			result = true;
		} catch (Exception e) {

		}
		em.getTransaction().commit();

		return result;
	}

//	***Learnable Skill methods***
	@Override
	public List<LearnableSkill> findAllLearnableSkills() {
		String query = "SELECT sn from Skillname sn";
		List<LearnableSkill> results = em.createQuery(query, LearnableSkill.class).getResultList();

		return results;
	}

	@Override
	public LearnableSkill createLearnableSkill(LearnableSkill learnableskill) {
		em.getTransaction().begin();
		em.persist(learnableskill);
		em.flush();
		em.getTransaction().commit();

		return learnableskill;
	}

	@Override
	public LearnableSkill updateLearnableSkill(int id, LearnableSkill learnableskill) {
		em.getTransaction().begin();
		LearnableSkill managed = em.find(LearnableSkill.class, id);
		managed.setId(learnableskill.getId());
		managed.setComment(learnableskill.getComment());
		managed.setSkillLevel(learnableskill.getSkillLevel());
		managed.setSkillName(learnableskill.getSkillName());
		managed.setUser(learnableskill.getUser());
		em.flush();
		em.getTransaction().commit();
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
		em.getTransaction().begin();

		try {
			em.remove(em.find(LearnableSkill.class, id));
			result = true;
		} catch (Exception e) {

		}
		em.getTransaction().commit();

		return result;
	}

}
