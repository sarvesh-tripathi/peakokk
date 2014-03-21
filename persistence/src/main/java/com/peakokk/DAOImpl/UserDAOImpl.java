package com.peakokk.DAOImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.peakokk.dao.IUserDAO;
import com.peakokk.domain.User;
import com.peakokk.domain.Usertype;

@Repository
public class UserDAOImpl /* extends HibernateDaoSupport */implements IUserDAO
{

    /********************************************************************************************************
     * PRIVATE VARIABLES
     */

    /*
     * private static final String INSERT = null;
     * private static final String SELECT_USER_AUTHENTICATION = null;
     * private static final String SELECT_USER_ID = null;
     * private static final String UPDATE_USER = null;
     */

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    /*
     * @Override
     * public User getUserByUserName(String username) throws SQLException,
     * DataAccessException {
     * 
     * Query queryResult;
     * 
     * queryResult = sessionFactory.getCurrentSession().createQuery(
     * "from user where username=:userName");
     * queryResult.setParameter("userName", new String(username));
     * return (User) queryResult.list().get(0);
     * }
     */

    @Override
    public User getUser(int userId)
    {

        List<User> userList = null;
        String hqlquery = "from User a where a.userId = userId";

        try
        {
            Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);

            query.setParameter("userId", userId);

            userList = (List<User>) query.list();

        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

        return (User) userList.get(0);
    }

    @Override
    public User getUser(String emailId) throws
            DataAccessException
    {

        List<User> user = null;
        String hqlquery = "from User a where a.emailId = emailId";

        try
        {
            Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);

            query.setParameter("emailId", emailId);

            user = (List<User>) query.list();
        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

        return (User) user.get(0);
    }

    @Override
    public Usertype getUserByUserType(String type) throws
            DataAccessException
    {

        List<Usertype> usertypeList = null;

        String hqlquery = "from Usertype a where a.userType = :type";

        try
        {

            Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);

            query.setParameter("type", type);

            usertypeList = (List<Usertype>) query.list();

        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

        return usertypeList != null && !usertypeList.isEmpty() ? usertypeList.get(0) : null;
    }

    @Override
    public User authentification(String emailId, String password) throws DataAccessException
    {
        List<User> list = null;
        User user = null;
        /* boolean userStatus = false; */

        String hqlquery = "from User where emailId =:emailId and password =:password";

        try
        {

            System.out.println("===================> DAO");
            Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);

            list = (List<User>) query.list();
            if(list != null && list.get(0) !=null)
            {
               user =  (User) list.get(0); 
                
            }
                       

            System.out.println("============================== DAO 2");
            
        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

        return user;
    }

    @Override
    public boolean isEmailIdExist(String emailId)
    {
       List<User> list =null;
       
      // String result = null;
     
       String hqlquery = "from User where emailId =:emailId";

       
           Query query = sessionFactory.getCurrentSession().createQuery(hqlquery);

           query.setParameter("emailId", emailId);
           
           
           System.out.println("======================" + emailId);
           list = (List<User>) query.list();
           if(list == null || list.size() == 0)
           {   
               
               System.out.println("Email do not exist");
               
              return false;
           }
           return true;
           
       } 
    
    @Override
    public String insert(User users) throws
            DataAccessException
    {
        /* sessionFactory.getCurrentSession().save(users); */

        return null;
    }

    @Override
    public String update(User users) throws DataAccessException
    {

        sessionFactory.getCurrentSession().update(users);
        return SUCCESS;
    }

    @Override
    public String save(User users) throws DataAccessException
    {

        sessionFactory.getCurrentSession().save(users);
        return SUCCESS;
    }

    @Override
    public String deleteUser(User users) throws DataAccessException
    {

        sessionFactory.getCurrentSession().delete(users);

        return SUCCESS;
    }

    @Override
    public List<User> selectAll() throws DataAccessException
    {
        return null;
    }

   

}