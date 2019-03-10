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
	public List<User> findAllActiveTutors() {
		String query = "SELECT u from User u where u.isActive = true and where u.teachableSkills is not null.";
		List<User> results = em.createQuery(query, User.class).getResultList();
		return results;
	}

	@Override
	public List<User> findAllActiveStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllTeachableSkillsFromActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
