package com.skilldistillery.tudorjpa.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.skilldistillery.tudorjpa.entities.User;

public class TutDAOUserImpl implements TutDAOUser {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutAdvisor");
	private EntityManager em = emf.createEntityManager();

	@Override
	public List<User> findAllUsers() {
		String query = "SELECT u from User u";
		List<User> results = em.createQuery(query, User.class).getResultList();
		return results;
	}

	@Override
	public List<User> findAllActiveUsers() {
		String query = "SELECT u from User u where u.isActive = true";
		List<User> results = em.createQuery(query, User.class).getResultList();
		return results;
	}

	@Override
	public List<User> findAllInactiveUsers() {
		String query = "SELECT u from User u where u.isActive = false";
		List<User> results = em.createQuery(query, User.class).getResultList();
		return results;
	}

	@Override
	public User createUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		User managed = em.find(User.class, id);
		managed.setFirstName(user.getFirstName());
		managed.setLastName(user.getLastName());
		managed.setEmail(user.getEmail());
		managed.setPhone(user.getPhone());
		managed.setAddressId(user.getAddressId());
		managed.setUsername(user.getUsername());
		managed.setPassword(user.getPassword());
		managed.setIsAdmin(user.getIsAdmin());
		managed.setIsActive(user.getIsActive());
		managed.setLearnableSkills(user.getLearnableSkills());
		managed.setTeachableSkills(user.getTeachableSkills());

		return managed;
	}

	@Override
	public User findUserById(int id) {
		User result = em.find(User.class, id);
		return result;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean result = false;
		em.getTransaction().begin();
		try {
			em.remove(em.find(User.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

}
