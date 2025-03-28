package com.pixelpulse.rest2025.model;

import java.io.Serializable;
import java.util.Date;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

// @NoArgsConstructor
// @AllArgsConstructor
@Data
public class Instructor implements Serializable {
	private static final long serailVersionUID = 1L;
	private static long idCounter = 1;
	
	private long id;
	private String name;
	private String lastName;
	private Date dateReg;
	private String email;
	private String password;
	
	
	public Instructor() {
        this.id = idCounter++; 
    }
	public Instructor(long id, String name, String lastName, Date dateReg, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dateReg = dateReg;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateReg() {
		return dateReg;
	}

	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
