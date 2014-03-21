package com.peakokk.domain;

public class ChefProfiles implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private Integer contactNumber;
	private String specialization;
	private String topRecipes;
	private String aboutMe;
	private String profileImgUrl;
	private String backgroundImgUrl;
	
	
	public ChefProfiles() {
		
	}
	
	public ChefProfiles(String firstName, String middleName, String lastName, String emailId, Integer contactNumber, String specialization, String topRecipes, String aboutMe, String profileImgUrl, String backgroundImgUrl) {

		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.contactNumber=contactNumber;
		this.specialization=specialization;
		this.topRecipes=topRecipes;
		this.aboutMe=aboutMe;
		this.profileImgUrl=profileImgUrl;
		this.backgroundImgUrl=backgroundImgUrl;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getProfileImgUrl() {
		return profileImgUrl;
	}

	public void setProfileImgUrl(String profileImgUrl) {
		this.profileImgUrl = profileImgUrl;
	}

	public String getBackgroundImgUrl() {
		return backgroundImgUrl;
	}

	public void setBackgroundImgUrl(String backgroundImgUrl) {
		this.backgroundImgUrl = backgroundImgUrl;
	}
	
}
