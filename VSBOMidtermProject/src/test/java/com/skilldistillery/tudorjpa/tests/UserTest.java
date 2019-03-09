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

import com.skilldistillery.tudorjpa.entities.User;

class UserTest {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TutAdvisor");
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
		user = null;
		em.close();

	}

	@Test
	void test_user_mapping() {
		assertEquals("James", user.getFirstName());
		assertEquals("Kirk", user.getLastName());
		assertEquals("james.t.kirk@ufop.net", user.getEmail());
		assertEquals("3347659876", user.getPhone());
		assertEquals("111 Test St", user.getAddressId().getAddress());
		assertEquals("3347659876", user.getPhone());
		assertEquals("Jimmy", user.getUsername());
		assertEquals("enterprise", user.getPassword());
		assertTrue(user.getIsAdmin());
		assertTrue(user.getIsActive());
	}

}
