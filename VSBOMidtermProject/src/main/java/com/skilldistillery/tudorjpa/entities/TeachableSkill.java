package com.skilldistillery.tudorjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeachableSkill {
//    DB columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teachable_id")
	private int id;

//	@Column(name = "user_id")
//	private User user;

//    @Column(name="skill_name_id")
//    private Skill skill;

//	@Column(name = "skill_level_id")
//	private SkillLevel skillLevel;

	@Column(name = "comment")
	private String comment;

//    @OneToOne
//    @JoinColumn(name="")
//    private Level level;

	// Getters and setters

}