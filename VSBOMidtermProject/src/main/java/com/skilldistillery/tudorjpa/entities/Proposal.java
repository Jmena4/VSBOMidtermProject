package com.skilldistillery.tudorjpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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

	@Column(name = "offer_amount")
	private Double offerAmount;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time_proposed")
	private Date dateTimeProposed;

	@Column(name = "duration")
	private Integer duration;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address addressId;

	@Column(name = "comment")
	private String comment;

	@Column(name = "proposal_status_id")
	private Integer proposalStatusId;

	@Column(name = "routing")
	private int routing;

//	@Temporal(TemporalType.TIMESTAMP)
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

	public Double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(Double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public Date getDateTimeProposed() {
		return dateTimeProposed;
	}

	public void setDateTimeProposed(Date dateTimeProposed) {
		this.dateTimeProposed = dateTimeProposed;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getProposalStatusId() {
		return proposalStatusId;
	}

	public void setProposalStatusId(Integer proposalStatusId) {
		this.proposalStatusId = proposalStatusId;
	}

	public int getRouting() {
		return routing;
	}

	public void setRouting(int routing) {
		this.routing = routing;
	}

	public Date getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", teacher=" + teacher + ", student=" + student + ", learnableId=" + learnableId
				+ ", teachableId=" + teachableId + ", offerAmount=" + offerAmount + ", dateTimeProposed="
				+ dateTimeProposed + ", duration=" + duration + ", addressId=" + addressId + ", comment=" + comment
				+ ", proposalStatusId=" + proposalStatusId + ", routing=" + routing + ", dateTimeCreated="
				+ dateTimeCreated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateTimeCreated == null) ? 0 : dateTimeCreated.hashCode());
		result = prime * result + ((dateTimeProposed == null) ? 0 : dateTimeProposed.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + id;
		result = prime * result + learnableId;
		result = prime * result + ((offerAmount == null) ? 0 : offerAmount.hashCode());
		result = prime * result + ((proposalStatusId == null) ? 0 : proposalStatusId.hashCode());
		result = prime * result + routing;
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
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (dateTimeCreated == null) {
			if (other.dateTimeCreated != null)
				return false;
		} else if (!dateTimeCreated.equals(other.dateTimeCreated))
			return false;
		if (dateTimeProposed == null) {
			if (other.dateTimeProposed != null)
				return false;
		} else if (!dateTimeProposed.equals(other.dateTimeProposed))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id != other.id)
			return false;
		if (learnableId != other.learnableId)
			return false;
		if (offerAmount == null) {
			if (other.offerAmount != null)
				return false;
		} else if (!offerAmount.equals(other.offerAmount))
			return false;
		if (proposalStatusId == null) {
			if (other.proposalStatusId != null)
				return false;
		} else if (!proposalStatusId.equals(other.proposalStatusId))
			return false;
		if (routing != other.routing)
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

	public Proposal() {
		super();
	}

}
