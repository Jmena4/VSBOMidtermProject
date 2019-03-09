package com.skilldistillery.tudorjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TeachableSkill {
//    DB columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teachable_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
    @JoinColumn(name="skill_name_id")
    private SkillName skill;

    @OneToOne
    @JoinColumn(name="skill_level_id")
    private SkillLevel level;

	@Column(name = "comment")
	private String comment;

	
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

	public SkillName getSkill() {
		return skill;
	}

	public void setSkill(SkillName skill) {
		this.skill = skill;
	}

	public SkillLevel getLevel() {
		return level;
	}

	public void setLevel(SkillLevel level) {
		this.level = level;
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
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

//	To String
	@Override
	public String toString() {
		return "TeachableSkill [id=" + id + ", user=" + user + ", skill=" + skill + ", level=" + level + ", comment="
				+ comment + "]";
	}
	
	
	
}