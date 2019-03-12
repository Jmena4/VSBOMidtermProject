package com.skilldistillery.tudorjpa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.tudorjpa.entities.Proposal;

@DisplayName("Proposal Entity Test")
class ProposalTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Proposal proposal;

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
		proposal = em.find(Proposal.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		proposal = null;
		em.close();
	}

	@Test
	void test_proposal_mapping() {
		assertEquals(1, proposal.getId());
		assertEquals(3, proposal.getTeacherId());
		assertEquals(1, proposal.getStudentId());
		assertEquals(3, proposal.getLearnableId());
		assertEquals(3, proposal.getTeachableId());
		assertEquals("8.0", proposal.getOfferAmount().toString());

		String pattern = "yyyy-MM-dd";
		String pattern2 = "HH:mm:ss";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(pattern);
		java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat(pattern2);

		assertEquals("2019-03-20 12:15:00",
				sdf.format(proposal.getDateTimeProposed()) + " " + sdf2.format(proposal.getDateTimeProposed()));
		assertEquals("60", proposal.getDuration().toString());
		assertEquals("I really need help", proposal.getComment());
		assertEquals("1", proposal.getProposalStatusId().toString());
		assertEquals(3, proposal.getRouting());
		assertEquals("2019-03-15 23:08:00",
				sdf.format(proposal.getDateTimeCreated()) + " " + sdf2.format(proposal.getDateTimeCreated()));

	}

}
