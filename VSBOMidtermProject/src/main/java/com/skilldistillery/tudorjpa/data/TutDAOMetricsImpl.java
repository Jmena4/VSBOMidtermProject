package com.skilldistillery.tudorjpa.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import com.skilldistillery.tudorjpa.entities.User;

public class TutDAOMetricsImpl implements TutDAOMetrics {
	

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutAdvisor");
	private EntityManager em = emf.createEntityManager();


	@Override
	public Long findActiveTutorCount() {
		String query = "SELECT count(distinct ts.user) from TeachableSkill ts";
		Long results =  (Long) em.createQuery(query).getSingleResult();
		return results;
	}

	@Override
	public Long findActiveStudentCount(){
		String query = "SELECT count(distinct ls.user) from LearnableSkill ls";
		Long results =  (Long) em.createQuery(query).getSingleResult();
		return results;
	}

	@Override
	public Long findTeachableSkillCount() {
		String query = "SELECT count(distinct ts) from TeachableSkill ts";
		Long results =  (Long) em.createQuery(query).getSingleResult();
		return results;
	}

	@Override
	public Long findLearnableSkillCount() {
		String query = "SELECT count(distinct ls) from LearnableSkill ls";
		Long results =  (Long) em.createQuery(query).getSingleResult();
		return results;
	}

	

}
