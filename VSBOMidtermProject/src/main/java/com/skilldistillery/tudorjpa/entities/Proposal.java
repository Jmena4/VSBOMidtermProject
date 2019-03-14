package com.skilldistillery.tudorjpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Proposal {
//	DB columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proposal_id")
	private int id;

	@OneToOne
	@JoinColumn(name = "teacher_id")
	private User teacher;

	@OneToOne
	@JoinColumn(name = "student_id")
	private User student;

	@Column(name = "learnable_id")
	private int learnableId;

	@Column(name = "teachable_id")
	private int teachableId;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "date_time_created")
	private Date dateTimeCreated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public int getLearnableId() {
		return learnableId;
	}

	public void setLearnableId(int learnableId) {
		this.learnableId = learnableId;
	}

	public int getTeachableId() {
		return teachableId;
	}

	public void setTeachableId(int teachableId) {
		this.teachableId = teachableId;
	}

	public Date getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

// Has Code and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTimeCreated == null) ? 0 : dateTimeCreated.hashCode());
		result = prime * result + id;
		result = prime * result + learnableId;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + teachableId;
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
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
		Proposal other = (Proposal) obj;
		if (dateTimeCreated == null) {
			if (other.dateTimeCreated != null)
				return false;
		} else if (!dateTimeCreated.equals(other.dateTimeCreated))
			return false;
		if (id != other.id)
			return false;
		if (learnableId != other.learnableId)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (teachableId != other.teachableId)
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
//	ToString

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", teacher=" + teacher + ", student=" + student + ", learnableId=" + learnableId
				+ ", teachableId=" + teachableId + ", dateTimeCreated=" + dateTimeCreated + "]";
	}

	public Proposal() {
		super();
	}
}