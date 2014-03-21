package com.peakokk.DTO;

public class ProfilePageDTO extends BaseDTO {
	
	private String firstName;
	private Integer contactNumber;
	private String specialization;
	private String topRecipes;
	private String aboutMe;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getTopRecipes() {
		return topRecipes;
	}
	public void setTopRecipes(String topRecipes) {
		this.topRecipes = topRecipes;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	
	

}
