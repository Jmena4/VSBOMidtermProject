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
@Table(name = "teachable_skill")
public class TeachableSkill {
//    DB columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teachable_id")
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

	@Column(name = "comment")
	private String comment;
	
	@Column(name="is_active")
	private boolean isActive;

	// Getters and setters

	public int getId() {
		return id;
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

	public void setSkillName(SkillName skillName) {
		this.skillName = skillName;
	}

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
//	Hash & Equals

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

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
		TeachableSkill other = (TeachableSkill) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeachableSkill [id=" + id + ", user=" + user + ", skillName=" + skillName + ", skillLevel=" + skillLevel
				+ ", comment=" + comment + "]";
	}

}