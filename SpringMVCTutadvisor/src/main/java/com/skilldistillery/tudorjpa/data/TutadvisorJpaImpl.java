package com.skilldistillery.tudorjpa.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service
public class TutadvisorJpaImpl implements TutDAO {

	@PersistenceContext
	private EntityManager em;
}
