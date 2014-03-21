package com.peakokk.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.peakokk.dao.IOrderDAO;
import com.peakokk.domain.OrderDetails;
import com.peakokk.domain.User;

@Component("OrderDAOImpl")
public class OrderDAOImpl extends HibernateDaoSupport implements IOrderDAO {
	
	/**
	 * Priavte Variables
	 */
	
	private SessionFactory sessionFactory;
	
	
	 @Autowired
	    public OrderDAOImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	
	private Session openSession() {  
       return sessionFactory.getCurrentSession();  
   }
	

	
	
	@Override
	public OrderDetails getOrder(int userId) {
		
		List<OrderDetails> orderList = null;
		
		String hqlquery = "from order_details where a.userId = userId";
		
		try
		
		{
			Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);
			
			
			query.setParameter("userId", userId);
			
			orderList = (List<OrderDetails>) query.list();           			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return (OrderDetails) orderList.get(0);		
		
	}

	
	
	@Override
	public String saveOrder(OrderDetails odr) {
		
		sessionFactory.getCurrentSession().save(odr);
		return SUCCESS;
	}

	@Override
	public String displayOrder(OrderDetails odr) {
		return null;
	}

	@Override
	public String deleteOrder(OrderDetails odr) {
		
		sessionFactory.getCurrentSession().delete(odr);
		return SUCCESS;
	}

	@Override
	public String updateOrder(OrderDetails odr) {
		
		sessionFactory.getCurrentSession().update(odr);
		return SUCCESS;
	}

}
