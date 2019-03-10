package com.skilldistillery.tudorjpa.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.skilldistillery.tudorjpa.entities.Proposal;

public class TutDAOProposalImpl implements TutDAOProposal {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutAdvisor");
	private EntityManager em = emf.createEntityManager();

	@Override
	public List<Proposal> findAllProposals() {
		String query = "SELECT p from Proposal p";
		List<Proposal> results = em.createQuery(query, Proposal.class).getResultList();
		return results;
	}

	@Override
	public Proposal createProposal(Proposal prop) {
		em.getTransaction().begin();
		em.persist(prop);
		em.getTransaction().commit();
		return prop;
	}

//	TODO - cant to this till proposal pulls in objects rather than just IDs. 
	@Override
	public Proposal updateProposal(int id, Proposal prop) {
//		Proposal managed = em.find((Proposal.class), id);
//		managed.set
		return null;
	}

	@Override
	public Proposal findProposalById(int id) {
		Proposal result = em.find(Proposal.class, id);
		return result;
	}

	@Override
	public boolean deleteProposal(int id) {
		boolean result = false;
		em.getTransaction().begin();
		try {
			em.remove(em.find(Proposal.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

}
