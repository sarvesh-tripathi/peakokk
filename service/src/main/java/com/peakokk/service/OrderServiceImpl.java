package com.peakokk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peakokk.dao.IOrderDAO;
import com.peakokk.domain.OrderDetails;
import com.peakokk.service.IOrderService;

@Service("OrderService")
public class OrderServiceImpl implements IOrderService {

	
	@Autowired
	IOrderDAO orderDAO;
	
	
	
	@Override
	public OrderDetails getOrderDetails(int userId) {
		
		return orderDAO.getOrder(userId);
		
	}

	@Override
	public String saveOrderDetails(OrderDetails odr) {
		return orderDAO.saveOrder(odr);
	}

	@Override
	public String displayOrderDetails(OrderDetails odr) {
		return null;
	}

	@Override
	public String deleteOrderDetails(OrderDetails odr) {
		return orderDAO.deleteOrder(odr);
	}

	@Override
	public String updateOrderDetails(OrderDetails odr) {
		return orderDAO.updateOrder(odr);
	}

}
