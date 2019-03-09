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

@Entity
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
	private Address address;

//	@OneToMany(mappedBy="learnable_skill")
//	private List<LearnableSkill> skills;

//	@OneToMany(mappedBy="teachable_skill")
//	private List<TeachableSkill> skills;

	@Column(name = "user_name")
	private String username;

	@Column(name = "password")
	private String password;
	@Column(name = "is_admin")
	private Boolean isAdmin;

	@Column(name = "is_active")
	private Boolean isActive;

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
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append(", isActive=");
		builder.append(isActive);
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

	public User() {
	}

}
