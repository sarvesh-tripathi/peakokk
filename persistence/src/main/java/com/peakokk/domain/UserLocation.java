package com.peakokk.domain;


/**
 * User generated by hbm2java
 */

public class UserLocation  implements java.io.Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String addressline1;
	private String addressline2;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String longitude;
	private String lattitude;
	public UserLocation(){
		
	}
	public UserLocation(String addressline1, String addressline2, String street, String city, String state, String country, String zipcode, String longitude, String lattitude){
		this.addressline1=addressline1;
		this.addressline2=addressline2;
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
		this.zipcode=zipcode;
		this.longitude=longitude;
		this.lattitude=lattitude;	
	}
	public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getAddressline1() {
        return this.addressline1;
    }
    
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }
    public String getAddressline2() {
        return this.addressline2;
    }
    
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipcode() {
        return this.zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLattitude() {
        return this.lattitude;
    }
    
    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }
}