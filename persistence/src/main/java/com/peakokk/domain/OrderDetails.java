package com.peakokk.domain;

import java.sql.Time;
import java.util.Date;

public class OrderDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer orderId;
	private Integer orderNumber;
	private String  cuisine;
	private String foodItem;
	private Integer quantity;
	private String deliveryOption;
	
	private Date dateOfOrder;
	private Time timeOfOrder;
	private Integer userId;
	private String instruction;
	
	
	
	
	public OrderDetails() {
    }

	
    public OrderDetails(Integer orderNumber,String cuisine, String foodItem, Integer quantity, String deliveryOption, Date dateOfOrder, Time timeOfOrder, Integer userId, String instruction) {
        this.orderNumber=orderNumber;
    	this.cuisine = cuisine; 
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.deliveryOption = deliveryOption;
        this.dateOfOrder = dateOfOrder;
        this.timeOfOrder = timeOfOrder;
        this.userId= userId;
        this.instruction=instruction;
    }
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDeliveryOption() {
		return deliveryOption;
	}
	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	public Time getTimeOfOrder() {
		return timeOfOrder;
	}
	public void setTimeOfOrder(Time timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getInstruction() {
		return instruction;
	}


	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	
	
}
