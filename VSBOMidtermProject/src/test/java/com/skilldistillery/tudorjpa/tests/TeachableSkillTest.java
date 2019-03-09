package com.skilldistillery.tudorjpa.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tudorjpa.entities.TeachableSkill;

class TeachableSkillTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private TeachableSkill ts;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TutAdvisor");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		ts = em.find(TeachableSkill.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ts = null;
		em.close();
	}
	
	@Test
	void test_learnable_skill_mapping() {
		assertEquals(1, ts.getId());
		assertEquals("James", ts.getUser().getFirstName());
		assertEquals("Tribble Husbandry", ts.getSkill().getName());
		assertEquals("No Experience", ts.getLevel().getName());
		assertEquals("I grow my own", ts.getComment());
	}
}