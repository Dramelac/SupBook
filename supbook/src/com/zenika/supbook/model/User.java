package com.zenika.supbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique=true)
	private String login;

	@Column(unique=false)
	private String password;

	@Column(unique=true)
	private String email;

	@Column(unique=false)
	private boolean isAdmin;

	@OneToMany(mappedBy = "user")
	private Collection<Post> posts;

	public User() {
	}

	public User(String login, String password, String firstname, String lastname, String email, String address, String phonenumber, boolean isAdmin) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.isAdmin = false;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public boolean getIsAdmin() {return isAdmin;}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

}
