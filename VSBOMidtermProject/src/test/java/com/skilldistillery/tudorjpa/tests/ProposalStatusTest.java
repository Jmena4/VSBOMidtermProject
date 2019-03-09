package com.skilldistillery.tudorjpa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tudorjpa.entities.ProposalStatus;

@DisplayName("Proposal Status Entity Test")
class ProposalStatusTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private ProposalStatus proposalStatus;

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
		proposalStatus = em.find(ProposalStatus.class, 4);
	}

	@AfterEach
	void tearDown() throws Exception {
		proposalStatus = null;
		em.close();
	}

	@Test
	void test_proposal_status_mapping() {
		assertEquals(4, proposalStatus.getId());
//		assertEquals("PENDING", proposalStatus.getName());
//		assertEquals("ACCEPTED", proposalStatus.getName());
//		assertEquals("DECLINED", proposalStatus.getName());
		assertEquals("CANCELLED BY ADMIN", proposalStatus.getName());
	}

}
