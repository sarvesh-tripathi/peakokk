package com.peakokk.dao;

import com.peakokk.domain.OrderDetails;

public interface IOrderDAO extends IBaseDAO {
	
	public OrderDetails getOrder(int userId);
	
	public String saveOrder(OrderDetails odr);
	
	public String displayOrder(OrderDetails odr);
	
	public String deleteOrder(OrderDetails odr);
	
	public String updateOrder(OrderDetails odr);
	
	
	

}
