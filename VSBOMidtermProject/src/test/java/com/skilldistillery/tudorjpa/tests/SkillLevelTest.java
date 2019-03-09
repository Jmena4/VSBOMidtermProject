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

import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.SkillLevel;

class SkillLevelTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private SkillLevel sl;

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
		sl = em.find(SkillLevel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		sl = null;
		em.close();
	}

	@Test
	void test_skill_level_mapping() {
		assertEquals(1, sl.getId());
		assertEquals("No Experience", sl.getName());
	}

}
