package com.peakokk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peakokk.DTO.OrderDTO;
import com.peakokk.domain.OrderDetails;
import com.peakokk.service.IOrderService;

@Controller
public class OrderPageController extends BaseController{

	
	
	@RequestMapping(value="/ord", method = RequestMethod.GET)
    public String showOrderPage(ModelMap model) {
       // model.addAttribute("true", "error");
        return ORDER_PAGE;
  
    }
	
	
	
	/**
	 * To get order details
	 * @param orderDTO
	 * @param bindResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/veiwOrderDetail",method=RequestMethod.GET)
	public String orderDetails(@ModelAttribute("formBean") OrderDTO orderDTO,
			BindingResult bindResult, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		try {
			
			String userId =request.getParameter("userId");
			
		//	OrderDTO odrDTO = new OrderDTO();
			
		    HttpSession session = request.getSession(true);
				
		    ArrayList<OrderDTO> ordrList ; 
		    ordrList = (ArrayList<OrderDTO>)session.getAttribute("cuisine");
		    ordrList = (ArrayList<OrderDTO>)session.getAttribute("foodItem");
		    ordrList = (ArrayList<OrderDTO>)session.getAttribute("instruction");
		    ordrList = (ArrayList<OrderDTO>)session.getAttribute("quantity");
		    
		    
				
			
				
				/*OrderDetails odr = orderService.getOrderDetails();
	              model.addAttribute(ORDER_DETAILS, odr);*/
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return "";
		
	}
	
	/**
	 * @param orderDTO
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
			
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String addMoreItem(@ModelAttribute("formBean") OrderDTO orderDTO,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
				
		String result = EMPTY_STRING;
		String message=ERROR_MESSAGE;
		
		try{
			
			
			HttpSession session = request.getSession(true);
			/*ArrayList<OrderDTO> ordr ;
			ordr = (ArrayList<OrderDTO>)session.getAttribute("cuisine");*/
			
			
			session.setAttribute("cuisine", new ArrayList<OrderDTO>());
			session.setAttribute("foodItem", new ArrayList<OrderDTO>());
			session.setAttribute("instruction", new ArrayList<OrderDTO>());
			session.setAttribute("quantity", new ArrayList<OrderDTO>());
			
			
			
		} catch(DataAccessException e) {
			e.printStackTrace();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "";
		
		
		
	}
	
	/**
	 * To save the order
	 * @param orderDTO
	 * @param bindResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */

	@RequestMapping(value="/order1", method = RequestMethod.GET)
	public String addOrder(@ModelAttribute("formBean") OrderDTO orderDTO,
			BindingResult bindResult, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		
		String result = EMPTY_STRING;
		String message=ERROR_MESSAGE;
		
		try{
		
			OrderDetails order = new OrderDetails();
			
			order.setCuisine(orderDTO.getCuisine());
			order.setFoodItem(orderDTO.getFoodItem());
			order.setQuantity(orderDTO.getQuantity());
			order.setTimeOfOrder(orderDTO.getTimeOfOrder());
			order.setDateOfOrder(orderDTO.getDateOfOrder());
			order.setDeliveryOption(orderDTO.getDeliveryOption());
			
			
		
			
		result = orderService.saveOrderDetails(order);
		message=sendMessage(model,result, SAVE_MESSAGE);
		
		
		}catch (DataAccessException e) {
			e.printStackTrace();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	return "order1";
	
	}
	
	
	/**
	 * To edit the order
	 * @param orderDTO
	 * @param bindResult
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/updateOrder",method=RequestMethod.POST)
	public @ResponseBody String updateOrder(@ModelAttribute("formBean") OrderDTO orderDTO,
			BindingResult bindResult, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String result = EMPTY_STRING;
		String message=ERROR_MESSAGE;
		try {
			
			OrderDetails order = new OrderDetails();
			
			result = orderService.updateOrderDetails(order);
			message=sendMessage(model,result,UPDATE_MESSAGE);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return message;
	}
	
	
	
	
	
	
	@Autowired
	IOrderService orderService;
	
	
	/**
	 * Private Variables
	 */
	private static final String ORDER_PAGE="order1";
	
}
