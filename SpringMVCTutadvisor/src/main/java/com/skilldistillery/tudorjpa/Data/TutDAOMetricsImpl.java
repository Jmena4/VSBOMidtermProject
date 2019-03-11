package com.skilldistillery.tudorjpa.Data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tudorjpa.entities.User;
@Transactional
@Service
public class TutDAOMetricsImpl implements TutDAOMetrics {
	
	@PersistenceContext
	private EntityManager em;



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
