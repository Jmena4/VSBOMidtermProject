package com.skilldistillery.tudorjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="learnable_skill")
public class LearnableSkill {

//  DB columns

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="learnable_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
    @JoinColumn(name="skill_name_id")
    private SkillName skillName;

    @OneToOne
    @JoinColumn(name="skill_level_id")
    private SkillLevel skillLevel;

	@Column(name = "comment")
	private String comment;

	
// getters, setters, hash & equals
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
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
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
		LearnableSkill other = (LearnableSkill) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (skillLevel == null) {
			if (other.skillLevel != null)
				return false;
		} else if (!skillLevel.equals(other.skillLevel))
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
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
		return "LearnableSkill [id=" + id + ", user=" + user + ", skill=" + skillName + ", level=" + skillLevel + ", comment="
				+ comment + "]";
	}
	
	
}