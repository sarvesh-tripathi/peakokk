package com.peakokk.service;

import com.peakokk.domain.OrderDetails;

public interface IOrderService extends IBaseService {
	
	public static final String SERVICE_NAME=IOrderService.class.getSimpleName();
	
	public OrderDetails getOrderDetails(int userId);
	
	public String saveOrderDetails(OrderDetails odr);
	
	public String displayOrderDetails(OrderDetails odr);
	
	public String deleteOrderDetails(OrderDetails odr);
	
	public String updateOrderDetails(OrderDetails odr);
	 
	

}
