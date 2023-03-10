package com.driver.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userName;

	private String password;

	private String firstName;

	private String lastName;

	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Blog> blogsByUser;

	public List<Blog> getBlogsByUser() {
		return blogsByUser;
	}

	public void setBlogsByUser(List<Blog> blogsByUser) {
		this.blogsByUser = blogsByUser;
	}

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.firstName = "test";
		this.lastName = "test";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}