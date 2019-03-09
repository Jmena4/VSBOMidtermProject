package com.skilldistillery.tudorjpa.tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tudorjpa.entities.Address;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;

@DisplayName("lernableMapping")
class LearnableSkillTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private LearnableSkill ls;

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
		ls = em.find(LearnableSkill.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		ls = null;
		em.close();
	}
	
	@Test
	void test_learnable_skill_mapping() {
		assertEquals(1, ls.getId());
		assertEquals("James", ls.getUser().getFirstName());
		assertEquals("Fun With Phasers", ls.getSkillName().getName());
		assertEquals("No Experience", ls.getSkillLevel().getName());
		assertEquals("This will be more fun than licking cold door knobs!", ls.getComment());
	}

}
