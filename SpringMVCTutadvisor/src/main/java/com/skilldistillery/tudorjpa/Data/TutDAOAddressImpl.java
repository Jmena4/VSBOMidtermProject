package com.skilldistillery.tudorjpa.Data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tudorjpa.entities.Address;
@Transactional
@Service
public class TutDAOAddressImpl implements TutDAOAddress {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<Address> findAllAddresses() {
		String query = "SELECT a from Address a";
		List<Address> results = em.createQuery(query, Address.class).getResultList();
		return results;
	}

	@Override
	public Address createAddresses(Address add) {
		em.getTransaction().begin();
		em.persist(add);
		em.getTransaction().commit();
		return add;
	}

	@Override
	public Address updateAddresses(int id, Address add) {
		Address managed = em.find(Address.class, add);
		managed.setAddress(add.getAddress());
		managed.setAddress2(add.getAddress2());
		managed.setCity(add.getCity());
		managed.setState(add.getState());
		managed.setPostalCode(add.getPostalCode());
		return managed;
	}

	@Override
	public Address findAddressesById(int id) {
		Address result = em.find(Address.class, id);
		
		return result;
	}

	@Override
	public boolean deleteAddresses(int id) {
		boolean result = false;
		em.getTransaction().begin();
		try {
			em.remove(em.find(Address.class, id));
			result = true;
		} catch (Exception e) {

		}

		return result;
	}

}
