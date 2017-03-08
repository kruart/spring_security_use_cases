package com.oreilly.security.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="AUTO_USER")
public class AutoUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long autoUserId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="EMAIL")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}
