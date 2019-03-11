package com.skilldistillery.tudorjpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address addressId;

	@OneToMany
	@JoinColumn(name = "learnable_id")
	private List<LearnableSkill> learnableSkills;

	@OneToMany
	@JoinColumn(name = "teachable_id")
	private List<TeachableSkill> teachableSkills;

	@Column(name = "user_name")
	private String username;

	@Column(name = "password")
	private String password;
	@Column(name = "is_admin")
	private Boolean isAdmin;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "picture_url")
	private String pictureURL;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public List<LearnableSkill> getLearnableSkills() {
		return learnableSkills;
	}

	public void setLearnableSkills(List<LearnableSkill> learnableSkills) {
		this.learnableSkills = learnableSkills;
	}

	public List<TeachableSkill> getTeachableSkills() {
		return teachableSkills;
	}

	public void setTeachableSkills(List<TeachableSkill> teachableSkills) {
		this.teachableSkills = teachableSkills;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", addressId=");
		builder.append(addressId);
		builder.append(", learnableSkills=");
		builder.append(learnableSkills);
		builder.append(", teachableSkills=");
		builder.append(teachableSkills);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", pictureURL=");
		builder.append(pictureURL);
		builder.append("]");
		return builder.toString();
	}

	public User(int id, String firstName, String lastName, String email, String phone, String username, String password,
			Boolean isAdmin, Boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((learnableSkills == null) ? 0 : learnableSkills.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pictureURL == null) ? 0 : pictureURL.hashCode());
		result = prime * result + ((teachableSkills == null) ? 0 : teachableSkills.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (learnableSkills == null) {
			if (other.learnableSkills != null)
				return false;
		} else if (!learnableSkills.equals(other.learnableSkills))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pictureURL == null) {
			if (other.pictureURL != null)
				return false;
		} else if (!pictureURL.equals(other.pictureURL))
			return false;
		if (teachableSkills == null) {
			if (other.teachableSkills != null)
				return false;
		} else if (!teachableSkills.equals(other.teachableSkills))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public User() {
	}

}
