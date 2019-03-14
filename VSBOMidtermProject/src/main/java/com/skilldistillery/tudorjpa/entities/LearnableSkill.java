package com.skilldistillery.tudorjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "learnable_skill")
public class LearnableSkill {

//  DB columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "learnable_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "skill_name_id")
	private SkillName skillName;

	@OneToOne
	@JoinColumn(name = "skill_level_id")
	private SkillLevel skillLevel;

	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name = "comment")
	private String comment;
	

// getters, setters, hash & equals
	
	public int getId() {
		return id;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SkillName getSkillName() {
		return skillName;
	}

	public void setSkillName(SkillName skill) {
		this.skillName = skill;
	}

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel level) {
		this.skillLevel = level;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

//	Hash & Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LearnableSkill other = (LearnableSkill) obj;
		if (id != other.id)
			return false;
		return true;
	}

//	To String
	@Override
	public String toString() {
		return "LearnableSkill [id=" + id + ", user=" + user + ", skill=" + skillName + ", level=" + skillLevel
				+ ", comment=" + comment + "]";
	}

}