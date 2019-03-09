package com.skilldistillery.tudorjpa.tests;

import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tudorjpa.entities.User;

class UserTest {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("In BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;

	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
