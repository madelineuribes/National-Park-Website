package com.techelevator.npgeek.Model.Survey;

import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	
	private Long id;
	private String parkCode;
	
	@NotBlank(message="*")
	private String email;
	@NotBlank(message="*")
	private String state;
	
	private String activityLevel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
}
