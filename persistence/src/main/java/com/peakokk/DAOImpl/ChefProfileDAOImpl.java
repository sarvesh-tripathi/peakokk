package com.peakokk.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peakokk.dao.IChefProfileDAO;

@Repository
public class ChefProfileDAOImpl implements IChefProfileDAO
{


    private SessionFactory sessionFactory;

    @Autowired
    public ChefProfileDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
    
    
    @Override
    public String saveImgUrl(String profileImgUrl)
    {
        sessionFactory.getCurrentSession().save(profileImgUrl);
        return SUCCESS;
    }

}
