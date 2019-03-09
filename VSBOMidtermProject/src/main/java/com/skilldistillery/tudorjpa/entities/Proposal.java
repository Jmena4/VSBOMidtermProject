package com.skilldistillery.tudorjpa.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposal {
//	DB columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proposal_id")
	private int id;

	@Column(name = "teacher_id")
	private int teacherId;

	@Column(name = "student_id")
	private int studentId;

	@Column(name = "learnable_id")
	private int learnableId;

	@Column(name = "teachable_id")
	private int teachableId;

	@Column(name = "offer_amount")
	private Double offerAmount;

	@Column(name = "date_time_proposed")
	private Date dateTimeProposed;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "comment")
	private String comment;

	@Column(name = "proposal_status_id")
	private Integer proposalStatusId;

	@Column(name = "rounting")
	private int rounting;

	@Column(name = "date_time_created")
	private Date dateTimeCreated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public int getRounting() {
		return rounting;
	}

	public void setRounting(int rounting) {
		this.rounting = rounting;
	}

	public Date getDateTimeCreated() {
		return dateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		this.dateTimeCreated = dateTimeCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dateTimeCreated == null) ? 0 : dateTimeCreated.hashCode());
		result = prime * result + ((dateTimeProposed == null) ? 0 : dateTimeProposed.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + id;
		result = prime * result + learnableId;
		result = prime * result + ((offerAmount == null) ? 0 : offerAmount.hashCode());
		result = prime * result + ((proposalStatusId == null) ? 0 : proposalStatusId.hashCode());
		result = prime * result + rounting;
		result = prime * result + studentId;
		result = prime * result + teachableId;
		result = prime * result + teacherId;
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
		if (rounting != other.rounting)
			return false;
		if (studentId != other.studentId)
			return false;
		if (teachableId != other.teachableId)
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Proposal [id=");
		builder.append(id);
		builder.append(", teacherId=");
		builder.append(teacherId);
		builder.append(", studentId=");
		builder.append(studentId);
		builder.append(", learnableId=");
		builder.append(learnableId);
		builder.append(", teachableId=");
		builder.append(teachableId);
		builder.append(", offerAmount=");
		builder.append(offerAmount);
		builder.append(", dateTimeProposed=");
		builder.append(dateTimeProposed);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", proposalStatusId=");
		builder.append(proposalStatusId);
		builder.append(", rounting=");
		builder.append(rounting);
		builder.append(", dateTimeCreated=");
		builder.append(dateTimeCreated);
		builder.append("]");
		return builder.toString();
	}

	public Proposal() {
		super();
	}

}
