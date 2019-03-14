package com.skilldistillery.tudorjpa.data;

import java.util.List;

import com.skilldistillery.tudorjpa.entities.Address;
import com.skilldistillery.tudorjpa.entities.LearnableSkill;
import com.skilldistillery.tudorjpa.entities.SkillLevel;
import com.skilldistillery.tudorjpa.entities.SkillName;
import com.skilldistillery.tudorjpa.entities.TeachableSkill;
import com.skilldistillery.tudorjpa.entities.User;

public class Suggestion {

	private int id;

	private SkillName skillName;

	private SkillLevel skillLevel;

	private User teacherUser;

	private User studentUser;

	private Address recommendationAddress;

	private TeachableSkill teachableSkills;

	private LearnableSkill learnableSkills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getTeacherUser() {
		return teacherUser;
	}

	public void setTeacherUser(User teacherUser) {
		this.teacherUser = teacherUser;
	}

	public User getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(User studentUser) {
		this.studentUser = studentUser;
	}

	public Address getRecommendationAddress() {
		return recommendationAddress;
	}

	public void setRecommendationAddress(Address recommendationAddress) {
		this.recommendationAddress = recommendationAddress;
	}

	public TeachableSkill getTeachableSkills() {
		return teachableSkills;
	}

	public void setTeachableSkills(TeachableSkill teachableSkills) {
		this.teachableSkills = teachableSkills;
	}

	public LearnableSkill getLearnableSkills() {
		return learnableSkills;
	}

	public void setLearnableSkills(LearnableSkill learnableSkills) {
		this.learnableSkills = learnableSkills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((learnableSkills == null) ? 0 : learnableSkills.hashCode());
		result = prime * result + ((recommendationAddress == null) ? 0 : recommendationAddress.hashCode());
		result = prime * result + ((skillLevel == null) ? 0 : skillLevel.hashCode());
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		result = prime * result + ((studentUser == null) ? 0 : studentUser.hashCode());
		result = prime * result + ((teachableSkills == null) ? 0 : teachableSkills.hashCode());
		result = prime * result + ((teacherUser == null) ? 0 : teacherUser.hashCode());
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
		Suggestion other = (Suggestion) obj;
		if (id != other.id)
			return false;
		if (learnableSkills == null) {
			if (other.learnableSkills != null)
				return false;
		} else if (!learnableSkills.equals(other.learnableSkills))
			return false;
		if (recommendationAddress == null) {
			if (other.recommendationAddress != null)
				return false;
		} else if (!recommendationAddress.equals(other.recommendationAddress))
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
		if (studentUser == null) {
			if (other.studentUser != null)
				return false;
		} else if (!studentUser.equals(other.studentUser))
			return false;
		if (teachableSkills == null) {
			if (other.teachableSkills != null)
				return false;
		} else if (!teachableSkills.equals(other.teachableSkills))
			return false;
		if (teacherUser == null) {
			if (other.teacherUser != null)
				return false;
		} else if (!teacherUser.equals(other.teacherUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", skillName=" + skillName + ", skillLevel=" + skillLevel + ", teacherUser="
				+ teacherUser + ", studentUser=" + studentUser + ", recommendationAddress=" + recommendationAddress
				+ ", teachableSkills=" + teachableSkills + ", learnableSkills=" + learnableSkills + "]";
	}

	public Suggestion() {
		super();
	}

}
