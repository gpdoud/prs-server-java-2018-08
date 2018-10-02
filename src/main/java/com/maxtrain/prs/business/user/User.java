package com.maxtrain.prs.business.user;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String email;
	@Column(name = "isReviewer")
	private boolean reviewer;
	@Column(name = "isAdmin")
	private boolean admin;
	@Column(name = "isActive")
	private boolean active;
	
	public User() {
		this.username = "";
		this.password = "";
	}

	public User(int id, String username, String password, String firstname, String lastname, String phonenumber,
			String email, boolean reviewer, boolean admin, boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
		this.active = active;
	}
	@Override
	public String toString() {
		return String.format("ID[%d], Username[%s], Password[%s], Name[%s %s], Phone[%s], Email[%s], Reviewer[%b], Admin[%b], Active[%b]", 
				this.id, this.username, this.password, this.firstname, this.lastname, 
				this.phonenumber, this.email, this.reviewer, this.admin, this.active);
	}

	public int getId() {
		return id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isReviewer() {
		return reviewer;
	}

	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
