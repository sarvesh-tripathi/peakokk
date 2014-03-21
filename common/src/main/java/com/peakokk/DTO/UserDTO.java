package com.peakokk.DTO;

import com.peakokk.DTO.BaseDTO;

public class UserDTO extends BaseDTO{
	private Integer userId;
	private String username;
    private String emailId;
    private String password;
    private String firstName;
    private String lastName;
    private Integer userTypeId;
    private Character gender;
    private String confirmPassword;   // for registration page
    private boolean termsCheckbox;
    private boolean emailRegister;
    private String contactNumber;
    
    
    
	
    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public Integer getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
 
	public boolean isTermsCheckbox()
    {
        return termsCheckbox;
    }
    public void setTermsCheckbox(boolean termsCheckbox)
    {
        this.termsCheckbox = termsCheckbox;
    }
    public boolean isEmailRegister()
    {
        return emailRegister;
    }
    public void setEmailRegister(boolean emailRegister)
    {
        this.emailRegister = emailRegister;
    }
    public String getContactNumber()
    {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }
}
