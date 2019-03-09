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

import com.skilldistillery.tudorjpa.entities.SkillName;

class SkillNameTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private SkillName sn;

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
		sn = em.find(SkillName.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		sn = null;
		em.close();
	}
	@Test
	void test() {
		assertEquals("Tribble Husbandry", sn.getName());
		assertEquals(1, sn.getId());
	}

}
